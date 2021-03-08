pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                sh """docker build -f Dockerfile.test -t calculator-test ."""
            }
        }

        stage("Test") {
            steps {
                sh """docker run -i calculator-test:latest"""
            }
        }

        stage("Push to Docker Hub") {
            steps {
                sh """docker build -f Dockerfile.production -t calculator ."""
                sh """docker tag calculator:latest kaustubhnair/calculator:latest"""
                sh """docker push kaustubhnair/calculator"""
            }
        }
        stage("Deploy to Ansible") {
            steps {
                sh """ssh-keygen -R 172.17.0.2"""
                sh """ssh-keygen -R 172.17.0.3"""
                ansiblePlaybook become: true, colorized: true, credentialsId: 'b2033d60-2fe1-47b4-9d92-320edc537849', disableHostKeyChecking: true, inventory: 'ansible.cfg', playbook: 'playbook.yml', sudoUser: null
            }
        }

        }
        post {

            failure {
            sh """curl -H "Content-Type: application/json" -X POST -d '{"state": "failure","context": "continuous-integration/jenkins", "description": "Jenkins", "target_url": "$JENKINS_URL/job/calculator/$BUILD_NUMBER/console"}' https://api.GitHub.com/repos/kaustubh-nair/calculator/statuses/$GIT_COMMIT?access_token=$GITHUB_ACCESS_TOKEN"""
            }
            success {
                    sh """curl -H "Content-Type: application/json" -X POST -d '{"state": "success","context": "continuous-integration/jenkins", "description": "Jenkins", "target_url": "$JENKINS_URL/job/calculator/$BUILD_NUMBER/console"}' https://api.GitHub.com/repos/kaustubh-nair/calculator/statuses/$GIT_COMMIT?access_token=$GITHUB_ACCESS_TOKEN"""
                }
        }
}
