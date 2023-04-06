pipeline{
	agent any
	stages{
		stage('Checkout'){
			steps{
				git branch: "main", url: 'https://github.com/Pratham232/g3-patient-info-service.git'
			
			}
			
		}
		
		stage('Build'){
			steps{
				sh 'chmod a+x mvnw'
				sh './mvnw clean package -DskipTests=true' 
			}
			
			post{
				always{
					archiveArtifacts 'target/*.jar'
				}
			}
		}
		
		stage(DockerBuild){
			steps{
				sh 'docker build -t itsmepratham23/g3-patient-info-service:patient-info-service-tag .'
				sh 'docker push itsmepratham23/g3-patient-info-service:patient-info-service-tag'
			}
		}
		
	}

}