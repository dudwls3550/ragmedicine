# 
## Data
https://www.aihub.or.kr/aihubdata/data/view.do?currMenu=115&topMenu=100&&srchDataRealmCode=REALM006&aihubDataSe=data&dataSetSn=71874


## Data structure
1. 데이터 구성  
(1) qa_id: 질의응답별 고유 id  
(2) domain: 의료분야  
(3) q_type: 질문 유형  
(4) question: 질문  
(5) answer: 답변  

 

2. 어노테이션 포맷  
(1) qa_id: 1-보라매병원, 2-삼성서울병원, 3-서울대병원, 4-서울성모병원, 5-세브란스병원, 6-크라우드웍스  
(2) domain: 1-외과, 2-예방의학, 3-정신건강의학과, 4-신경과/신경외과, 5-피부과, 6-안과, 7-이비인후과, 8-비뇨의학과, 9-방사선종양학과, 10-병리과, 11-마취통증의학과, 12-의료법규, 13-기타, 14-산부인과, 15-소아청소년과, 16-응급의학과, 17-내과  
(3) q_type: 1-객관식, 2-단답형, 3-서술형  
(4) question: 질문 텍스트  
(5) answer: 답변 텍스트  


3. 데이터 포맷  
Json 형식  
{    "﻿qa_id": "",  
    "domain": "",  
    "q_type": "",  
    "question": "",  
    "answer": ""  
}  

 

4. 실제 예시  
{    "﻿qa_id": "65",  
    "domain": "13",  
    "q_type": "1",  
    "question": "35세 여성이 항레트로바이러스제 STRIBILD(Emtricitabine+Tenofovir Alafenamide+Elvitegravir+Cobicistat)를 과다 복용한 후 병원에 내원하였다. 활력징후는 혈압 110/70mmHg, 맥박 88회/분, 호흡 18회/분, 체온 37.2°C로 측정되었으며, 현재 특별한 증상은 없다. 의료진은 그녀의 상태를 모니터링하고 있다. STRIBILD의 구성 성분인 엘비테그라비르, 코비시스타트, 엠트리시타빈, 테노포비르 DF 각각의 과량 투여에 대한 임상적 경험이 제한적이다. 다음 중 STRIBILD의 성분에 대한 설명으로 옳지 않은 것은?\n1) 엘비테그라비르는 혈장 단백질에 강하게 결합되어 있어 혈액투석이나 복막투석으로 효과적으로 제거되지 않을 가능성이 높다.\n2) 코비시스타트는 400 mg 단일 투여 시 심각한 부작용이 보고되지 않았다.\n3) 엠트리시타빈은 혈액투석으로 약 30%가 제거될 수 있으며, 복막투석으로 제거가 가능한지는 알려져 있지 않다.\n4) 테노포비르 DF는 600 mg 투여 시 심각한 부작용이 보고되었으며, 혈액투석으로 약 54%가 제거될 수 있다.\n5) STRIBILD의 과다 복용 시 일반적인 지원 조치로 환자의 임상 상태를 관찰하고 활력 징후를 모니터링하는 것이 중요하다.",  
    "answer": "4) 테노포비르 DF는 600 mg 투여 시 심각한 부작용이 보고되었으며, 혈액투석으로 약 54%가 제거될 수 있다."  
}  


## Model
www.msaez.io/#/109127043/storming/RAG_medicine

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- AuditLog
- QnAEngine
- Authentication
- ExternalMedicalKnowledgeSync
- FeedbackNotification
- ResidentQnA
- UserManagement
- ResidentQnA
- QnAEngine
- Authentication
- AuditLog
- UserManagement
- ExternalMedicalKnowledgeSync
- FeedbackNotification
- ui


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- AuditLog
```
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
```
- QnAEngine
```
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
```
- Authentication
```
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
```
- ExternalMedicalKnowledgeSync
```
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
```
- FeedbackNotification
```
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
```
- ResidentQnA
```
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
```
- UserManagement
```
 http :8088/ 
 http :8088/ 
 http :8088/ 
 http :8088/ 
```
- ResidentQnA
```
 http :8088/feedbacks feedbackId="feedbackId"residentId="residentId"feedbackContent="feedbackContent"adminNotificationSent="adminNotificationSent"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/questionAnswers questionAnswerId="questionAnswerId"residentId="residentId"questionContent="questionContent"validationResult="validationResult"answerContent="answerContent"answerSource="answerSource"answerGeneratedAt="answerGeneratedAt"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/feedbacks feedbackId="feedbackId"residentId="residentId"feedbackContent="feedbackContent"adminNotificationSent="adminNotificationSent"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/questionAnswers questionAnswerId="questionAnswerId"residentId="residentId"questionContent="questionContent"validationResult="validationResult"answerContent="answerContent"answerSource="answerSource"answerGeneratedAt="answerGeneratedAt"createdAt="createdAt"updatedAt="updatedAt"
```
- QnAEngine
```
 http :8088/answerGenerations answerGenerationId="answerGenerationId"questionContent="questionContent"answerContent="answerContent"createdAt="createdAt"reliabilityScore="reliabilityScore"personalInfoFiltered="personalInfoFiltered"
 http :8088/sourceEvidences sourceEvidenceId="sourceEvidenceId"answerGenerationId="answerGenerationId"sourceTitle="sourceTitle"sourceUrl="sourceUrl"retrievedAt="retrievedAt"
 http :8088/sourceEvidences sourceEvidenceId="sourceEvidenceId"answerGenerationId="answerGenerationId"sourceTitle="sourceTitle"sourceUrl="sourceUrl"retrievedAt="retrievedAt"
 http :8088/answerGenerations answerGenerationId="answerGenerationId"questionContent="questionContent"answerContent="answerContent"createdAt="createdAt"reliabilityScore="reliabilityScore"personalInfoFiltered="personalInfoFiltered"
```
- Authentication
```
 http :8088/authorizations authorizationId="authorizationId"role="role"permissionType="permissionType"grantedAt="grantedAt"revokedAt="revokedAt"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/authenticationTokens tokenId="tokenId"tokenValue="tokenValue"issuedAt="issuedAt"expiresAt="expiresAt"lastValidatedAt="lastValidatedAt"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/authenticationTokens tokenId="tokenId"tokenValue="tokenValue"issuedAt="issuedAt"expiresAt="expiresAt"lastValidatedAt="lastValidatedAt"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/authorizations authorizationId="authorizationId"permissionType="permissionType"grantedAt="grantedAt"revokedAt="revokedAt"createdAt="createdAt"updatedAt="updatedAt"
```
- AuditLog
```
 http :8088/auditLogs auditLogId="auditLogId"eventTimestamp="eventTimestamp"actorId="actorId"actorType="actorType"eventData="eventData"logLevel="logLevel"createdAt="createdAt"updatedAt="updatedAt"retentionExpiryAt="retentionExpiryAt"
 http :8088/logRetentionPolicies logRetentionPolicyId="logRetentionPolicyId"policyName="policyName"retentionPeriodYears="retentionPeriodYears"isActive="isActive"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/logRetentionPolicies logRetentionPolicyId="logRetentionPolicyId"policyName="policyName"retentionPeriodYears="retentionPeriodYears"isActive="isActive"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/auditLogs auditLogId="auditLogId"eventTimestamp="eventTimestamp"actorId="actorId"eventData="eventData"createdAt="createdAt"updatedAt="updatedAt"retentionExpiryAt="retentionExpiryAt"
```
- UserManagement
```
 http :8088/abnormalActivities abnormalActivityId="abnormalActivityId"detectedAt="detectedAt"description="description"detectedBy="detectedBy"detectionResult="detectionResult"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/ 
 http :8088/users userId="userId"encryptedPassword="encryptedPassword"abnormalActivityCount="abnormalActivityCount"feedbackDissatisfactionCount="feedbackDissatisfactionCount"lastLoginAt="lastLoginAt"createdAt="createdAt"updatedAt="updatedAt"suspendedAt="suspendedAt"suspendedReason="suspendedReason"
 http :8088/users userId="userId"abnormalActivityCount="abnormalActivityCount"feedbackDissatisfactionCount="feedbackDissatisfactionCount"lastLoginAt="lastLoginAt"createdAt="createdAt"updatedAt="updatedAt"suspendedAt="suspendedAt"suspendedReason="suspendedReason"
 http :8088/abnormalActivities abnormalActivityId="abnormalActivityId"description="description"detectedAt="detectedAt"detectedBy="detectedBy"detectionResult="detectionResult"createdAt="createdAt"updatedAt="updatedAt"
```
- ExternalMedicalKnowledgeSync
```
 http :8088/knowledgeSyncs syncId="syncId"externalDbStatus="externalDbStatus"lastSyncedAt="lastSyncedAt"syncCycle="syncCycle"syncData="syncData"syncLog="syncLog"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/syncFailureAlerts alertId="alertId"syncId="syncId"failureReason="failureReason"notifiedAt="notifiedAt"
 http :8088/knowledgeSyncs syncId="syncId"lastSyncedAt="lastSyncedAt"syncCycle="syncCycle"externalDbStatus="externalDbStatus"syncData="syncData"syncLog="syncLog"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/syncFailureAlerts alertId="alertId"syncId="syncId"failureReason="failureReason"notifiedAt="notifiedAt"
```
- FeedbackNotification
```
 http :8088/feedbackNotifications notificationId="notificationId"feedbackStatisticsId="feedbackStatisticsId"adminId="adminId"eventLevel="eventLevel"triggeredAt="triggeredAt"createdAt="createdAt"
 http :8088/feedbackNotificationStatistics feedbackStatisticsId="feedbackStatisticsId"totalFeedbackCount="totalFeedbackCount"dissatisfiedFeedbackCount="dissatisfiedFeedbackCount"dissatisfiedFeedbackRatio="dissatisfiedFeedbackRatio"aggregatedAt="aggregatedAt"
 http :8088/feedbackNotificationStatistics feedbackStatisticsId="feedbackStatisticsId"totalFeedbackCount="totalFeedbackCount"dissatisfiedFeedbackCount="dissatisfiedFeedbackCount"dissatisfiedFeedbackRatio="dissatisfiedFeedbackRatio"aggregatedAt="aggregatedAt"
 http :8088/feedbackNotifications notificationId="notificationId"feedbackStatisticsId="feedbackStatisticsId"adminId="adminId"eventLevel="eventLevel"triggeredAt="triggeredAt"createdAt="createdAt"
```
- ui
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
