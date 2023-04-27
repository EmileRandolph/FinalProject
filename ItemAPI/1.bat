docker stop ItemAPI
docker rm ItemAPI
docker rmi itemapi:1
REM docker build --no-cache -t itemapi:1 .
docker build -t itemapi:1 .
docker run -d -p 8090:8090 --name ItemAPI --net ecommerce itemapi:1
