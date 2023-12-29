pipeline {
    agent any

    parameters {
        string(name: 'SPEC', defaultValue: "komagene/src/test/resources/features/smoke.feature", description: "Enter the feature file for execution")
        choice(name: 'BROWSER', choices:['chrome', 'firefox', 'edge'], description: "Choose the browser to execute")
    }

    stages {
        stage('Building') {
            steps {
                echo "Building the application"
                // Burada projenizi derlemek için gerekli adımları ekleyebilirsiniz.
                // Örneğin: sh "mvn clean install"
            }
        }

        stage('Testing') {
            steps {
                script {
                    echo "Running Maven Install"
                    sh "mvn clean install"

                    echo "Running Cucumber Tests"
                    sh "npx cucumber-js --browser ${BROWSER} --spec ${SPEC}"
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Application deployed"
                // Burada uygulamanızın dağıtımı için gerekli adımları ekleyebilirsiniz.
            }
        }
    }
}
