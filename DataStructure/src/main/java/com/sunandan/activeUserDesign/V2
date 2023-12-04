Diagram - https://app.diagrams.net/#G1Fh64W8sPWd7aeksvmh-jIGmvGa9NGSma

ActiveUserProcessing Service

POST /visit
    -> Database Update

CRON 5 MINUTE
    -> Query Database
    -> ActiveUserService POST


ServerLess ??

Database
 - Redis
 - JavaScript


 somebody create an event

 mock Events -> 

 /visit
 TODO:
     -> CRON outside ActiveUserProcessingService
     -> Database Update
        -> ActiveUserProcessing docker
     // 1 hour
     -> Redis username/password/hostname
        -> Redis docker

 generate SNS ??
     -> Database Update
     -> Redis username/password/hostname


Why should i not install Redis rather than using a docker?

docker-compose up
    Provide endpoints to interact with each other

    ActiveUserProcessing Service -> image
    Redis Service -> image

nodejs install

Kubernetes
ECS ??ActiveUserProcessing Service

POST /visit
    -> Database Update

CRON 5 MINUTE
    -> Query Database
    -> ActiveUserService POST


ServerLess:

generate SNS ??
     -> Database Update
     -> Redis username/password/hostname


Database
 - Redis
 - JavaScript

 somebody create an event

 mock Events -> 

 /visit
 TODO:
     -> ActiveUserProcessing docker [2]
        -> Rest API for [POST /activeUser ]
            -> Redis update with TTL
        -> Rest API for [GET /visits?pageId]
            -> Query Redis
     -> ActiveUser service in docker nodejs [3]
        -> Rest API for [GET /activeUsers] 
        -> Call ActiveUserProcessing to get active users
        -> Create local cache
     -> Create Redis username/password/hostname. [1.1]
        -> Redis docker [1.2]
     -> docker-compose with three images -> ActiveUser,ActiveUserProcessing and Redis
        -> Verify if they can interact with each other [4]
     -> Testing using mock data to see if things work 

Why should i not install Redis rather than using a docker?

docker-compose up
    Provide endpoints to interact with each other

    ActiveUserProcessing Service -> image
    Redis Service -> image

nodejs install

Kubernetes
ECS ??
