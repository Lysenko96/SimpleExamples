# Generate certificate
keytool -genkeypair -keystore acmesoft1.certs -alias acmeroot
keytool -exportcert -keystore acmesoft1.certs -alias acmeroot -file acmeroot1.cer