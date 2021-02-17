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

        stage("Deploy") {
            steps {
                sh """docker build -f Dockerfile.production -t calculator ."""
                sh """docker tag calculator:latest kaustubhnair/calculator:latest"""
                sh """docker push kaustubhnair/calculator"""
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
