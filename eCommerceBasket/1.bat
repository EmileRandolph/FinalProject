docker stop ecommerceBasketService
docker rm ecommerceBasketService
docker rmi ecommercebasketservice:1
REM docker build --no-cache -t ecommercebasketservice:1 .
docker build -t ecommercebasketservice:1 .
docker run -d -p 8081:8080 --name ecommerceBasketService --net ecommerce ecommercebasketservice:1