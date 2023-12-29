pipeline{
    agent any
    parameters{
        string(name: 'SPEC', defaultValue: "komagene/src/test/resources/features/smoke.feature", description: "Enter the feature file for execution")
        choice(name: 'BROWSER', choices:['chrome', 'firefox', 'edge'], description: "Choice the browser to execute")
    }
    stages{
        stage('Building'){
            steps{
                 echo "Building the application"
            }

        }
        stage('Testing'){
            steps{
                sh "mvn install"
                sh "npx cucumber-js --browser ${BROWSER} --spec ${SPEC}"
            }
        }
        stage('Deploy'){
            steps{
                echo "Application deployed"
            }


}
}