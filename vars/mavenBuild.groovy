def call() {
    stage('Build using shared Library') {
        echo "Running Maven build from Shared Library..."
        sh 'mvn clean package'
    }
}


