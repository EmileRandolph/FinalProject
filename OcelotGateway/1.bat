CLS

docker stop ecommerceGatewayOcelot
docker rm ecommerceGatewayOcelot
docker rmi ecommerceocelotgatewayapi:1
docker build --no-cache -t ecommerceocelotgatewayapi:1 .
docker run -d -p 8093:80 --name ecommerceGatewayOcelot --net ecommerce ecommerceocelotgatewayapi:1