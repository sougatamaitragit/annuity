# Annuity Replayment Schedule

This small guide will help user of this project / tool to download, compile, test and run annuity processing applicatiom.

# Project Technology 
This project expose a REST api to caluclate repayment schudle , annuity amount , interest and principal amount , outsytanding interest amount for annutiy loan. This project is developed using java / spring boot 2 / swagger .

# Download the project and readme file.
Please use below link to download the required files 

https://github.com/sougatamlendico/lendico.git 

# Setup 

Application's root directory  is annuitypayment folder . 

# Pre-requisite 
To run this application , jdk 1.8 and maven must be configured in the workstation.

# Build / Compile application 

To build the workspace , please use below command from workspace home directory , where pom.xml resides.  Once you download it from git annuitypayment will be your home directory . 

To build / compile workspace and run unit tests please issue following command from home directory 

mvn clean compile test.

# Package Application 
In order to package application as jar file , kindly issue following command from workspace home directory .

mvn package 

This will create a executable jar file under annuitypayment/target folder . Name of the jat file is annuitypayment-0.0.1.jar

# Execute the application 

To execute the application kindly go to target folder mentioned above or you can copy jar file any folder of your choice and run below command

java -jar annuitypayment-0.0.1.jar

# Port 

By default application is running in 8080 port. Kindly make sure port is available .

# Execution 

Once you able to execute this , you can use any standard Rest client tool to use it . 

Service is available in below URL 
http://your-machineip/replaymentschudele

   # Service's HTTP Method is: Post.

   # Security : Currently no security is configured so no need for any HTTP Basic or Transport layer security.
 
   #  Sample Request
  Following is a sample request to test the service . 

    {
    "loanAmount": "5000",
    "nominalRate": "5.0",
    "duration": 24,
    "startDate": "2018-01-01T00:00:01Z"
    }

All fields are mandatory , input validation is provided in the application so wrong value will give a BAD_REQUEST error with HTTP 400 error code.
For succes you will receive a HTTP 200 success code along with below structure response 
   # Media Type
    application/json
   # Successful Response
     http status code 200
     
     Response body is below

{
[
 {
 "borrowerPaymentAmount": "219.36",
 "date": "2018-01-01T00:00:00Z",
 "initialOutstandingPrincipal": "5000.00",
 "interest": "20.83",
 "principal": "198.53",
 "remainingOutstandingPrincipal": "4801.47",
 },
 {
 "borrowerPaymentAmount": "219.36",
 "date": "2018-02-01T00:00:00Z",
 "initialOutstandingPrincipal": "4801.47",
 "interest": "20.01",
 "principal": "199.35",
 "remainingOutstandingPrincipal": "4602.12",
 },
...
 {
 "borrowerPaymentAmount": "219.28",
 "date": "2020-01-01T00:00:00Z",
 "initialOutstandingPrincipal": "218.37",
 "interest": "0.91",
 "principal": "218.37",
 "remainingOutstandingPrincipal": "0",
 }
]
}

 # Data Validation Failure
   For invalid input HTTP Status code is 400 
   
 # Other Server Error
 
   For any other server side error response will contain HTTP 500 error code. So while integrating the tool one should and must check  http 200 code for success and any other code faiilure.
  
  # API Documentations
  A swagger documentation is also provided so that ,one can look into in deail about the request and response structure and data types  and formats,

Swagger documentation is avaiable in http://your-machine-ip/swagger-ui.html url.
  

# Assumptions 
There is no need for security as per requirement so any application can access the API.

# Constraints 
Since , logfile is not confired any excpetion will now redirected to console. This is a scope of improvement for future work. But, if it is packaged as a container image , then console log can be an option.
