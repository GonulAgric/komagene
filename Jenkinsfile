pipeline {
    agent any

    options {
        buildDiscarder(logRotator(artifactNumToKeepStr: '1', numToKeepStr: '5'))
    }

    environment {
        WORKSPACE = pwd()
    }

    tools {
        maven 'MavenToolName' // MavenToolName, Jenkins yükleminizde tanımlı olan Maven aracının adı olmalıdır.
    }

    parameters {
        string(name: 'SPEC', defaultValue: "komagene/src/test/resources/features/smoke.feature", description: "Enter the feature file for execution")
        choice(name: 'BROWSER', choices:['chrome', 'firefox', 'edge'], description: "Choose the browser to execute")
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir("${WORKSPACE}/komagene") {
                    script {
                        echo "Building the application"
                        sh "mvn clean install"
                    }
                }
            }
        }

        stage('Test') {
            steps {
                dir("${WORKSPACE}/komagene") {
                    script {
                        echo "Running Cucumber Tests"
                        sh "npx cucumber-js --browser ${BROWSER} --spec ${SPEC}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Application deployed"
            }
        }
    }
}
