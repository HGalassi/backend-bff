# Read Me First

* Esse projeto contém um exemplo de como utilizar o AWS SDK para Java,
com o objetivo de realizar a autenticação utilizando o AWS STS (Security Token Service)
e realizar uma chamada ao App Config AWS utilizando um token gerado pelo STS auth.
* Você pode testar por exemplo um Get Application, utilizando a chamada CURL: 
```bash 
curl -X GET http://localhost:8081/applications/1
```

# Getting Started

Para rodar o projeto crie um arquivo docker-run.sh

#!/bin/sh

# Defina as variáveis de ambiente
AWS_ROLE_ARN="your_role" # Exemplo: arn:aws:iam::123456789012:role/your-role  
AWS_ACCESS_KEY_ID="your_access_key_id" # Exemplo: AKIAIOSFODNN7EXAMPLE  
AWS_SECRET_ACCESS_KEY="your_secret_access_key" # Exemplo: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY  
AWS_REGION="your-region" # Exemplo: us-east-1  

# Execute o contêiner Docker
docker run -e AWS_ROLE_ARN=$AWS_ROLE_ARN \
-e AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID \
-e AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY \
-e AWS_REGION=$AWS_REGION \
your_image_name
