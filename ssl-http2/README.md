# Generate a self-signed SSL certificate

## Generate an SSL certificate in a keystore

keytool -genkeypair -alias localhost -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650 -storepass password

localhost: the alias name for the item we are generating.

## Verify the keystore content

keytool -list -v -storetype pkcs12 -keystore keystore.p12


# References
https://www.thomasvitale.com/https-spring-boot-ssl-certificate/