def call() {
    echo "Running Maven build from Shared Library..."
    sh 'mvn clean package'
}

