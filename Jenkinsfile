pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                echo "Hello world"
            }
        }
        stage("Error") {
            steps {
            sh """curl -H "Content-Type: application/json" -X POST -d '{"state": "failure","context": "continuous-integration/jenkins", "description": "Jenkins", "target_url": "$JENKINS_URL/job/calculator/$BUILD_NUMBER/console"}' https://api.GitHub.com/repos/kaustubh-nair/calculator/statuses/$GIT_COMMIT?access_token=$GITHUB_ACCESS_TOKEN"""
            }
        }
        stage("Success") {
            steps {
                sh """curl -H "Content-Type: application/json" -X POST -d '{"state": "success","context": "continuous-integration/jenkins", "description": "Jenkins", "target_url": "$JENKINS_URL/job/calculator/$BUILD_NUMBER/console"}' https://api.GitHub.com/repos/kaustubh-nair/calculator/statuses/$GIT_COMMIT?access_token=$GITHUB_ACCESS_TOKEN"""
            }
            }
        }
}
