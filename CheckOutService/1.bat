docker stop ecomerceCheckOutService
docker rm ecomerceCheckOutService
docker rmi ecomercecheckoutservice:1
REM docker build --no-cache -t ecomercecheckoutservice:1 .
docker build -t ecomercecheckoutservice:1 .
docker run -d -p 8092:8092 --name ecomerceCheckOutService --network ecommerce ecomercecheckoutservice:1