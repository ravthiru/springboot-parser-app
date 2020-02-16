psql -h localhost mydb postgres

mvn clean install
docker-compose up --build

http://localhost:8080/user/save

 curl -s -v -i -X POST -H "Content-Type: multipart/form-data" -F "file=@Input.txt" http://localhost:8080/upload

curl -v -X POST -H "Content-Type: multipart/form-data" -F "file=@Input.txt" http://localhost:8080/upload

curl -v http://localhost:8080/report
http://localhost:8080/report


{"clientSummary":[{"productSummary":[{"clientType":"CL  ","clientNumber":"1234","accountNumber":"0001","subAccountNumber":"0001","exchangeCode":"SGX ","productGroupCode":"FU","symbol":"NK    ","expirationDate":"20100910","transactionAmount":"$1,000.00"}]},{"productSummary":[{"clientType":"CL  ","clientNumber":"4321","accountNumber":"0001","subAccountNumber":"0001","exchangeCode":"SGX ","productGroupCode":"FU","symbol":"NK    ","expirationDate":"20100910","transactionAmount":"$46.00"}]}]}