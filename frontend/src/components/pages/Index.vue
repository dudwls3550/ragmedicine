<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "피드백",
          link: "/feedbacks",
      },
      {
          text: "질문-답변",
          link: "/questionAnswers",
      },
      {
          text: "피드백",
          link: "/feedbacks",
      },
      {
          text: "질문-답변",
          link: "/questionAnswers",
      },
      {
          text: "질문/답변 상세",
          link: "/questionAnswerDetails",
      },
      {
          text: "피드백 요약 목록",
          link: "/feedbackSummaries",
      },
      {
          text: "피드백 상세 정보",
          link: "/feedbackDetails",
      },
      {
          text: "질문 내역 조회",
          link: "/questionHistories",
      },
      {
          text: "피드백 목록 요약",
          link: "/feedbackSummaries",
      },
      {
          text: "피드백 상세 정보",
          link: "/feedbackDetails",
      },
      {
          text: "질문/답변 상세",
          link: "/questionAnswerDetails",
      },
      {
          text: "질문 내역 조회",
          link: "/questionHistories",
      },
      {
          text: "답변 생성",
          link: "/answerGenerations",
      },
      {
          text: "출처 정보",
          link: "/sourceEvidences",
      },
      {
          text: "출처 정보",
          link: "/sourceEvidences",
      },
      {
          text: "답변 생성",
          link: "/answerGenerations",
      },
      {
          text: "출처 인용 정보",
          link: "/sourceCitations",
      },
      {
          text: "피드백 요약",
          link: "/feedbackSummaries",
      },
      {
          text: "답변 상세 정보",
          link: "/answerDetails",
      },
      {
          text: "지식 출처 목록",
          link: "/knowledgeSourceIndices",
      },
      {
          text: "근거 인용 목록",
          link: "/evidenceCitationLists",
      },
      {
          text: "생성된 답변 상세 정보",
          link: "/generatedAnswerDetails",
      },
      {
          text: "지식 출처 상세 참조",
          link: "/knowledgeSourceReferences",
      },
      {
          text: "질문 기록 목록",
          link: "/questionHistories",
      },
      {
          text: "권한 관리",
          link: "/authorizations",
      },
      {
          text: "인증 토큰",
          link: "/authenticationTokens",
      },
      {
          text: "인증 토큰",
          link: "/authenticationTokens",
      },
      {
          text: "권한 관리",
          link: "/authorizations",
      },
      {
          text: "권한 목록 조회",
          link: "/permissionLists",
      },
      {
          text: "사용자 접근 프로필",
          link: "/userAccessProfiles",
      },
      {
          text: "토큰 상세 정보",
          link: "/tokenDetails",
      },
      {
          text: "인증 세션 조회",
          link: "/authenticationSessions",
      },
      {
          text: "접근 제어 목록",
          link: "/accessControlLists",
      },
      {
          text: "토큰 상태 조회",
          link: "/tokenStatuses",
      },
      {
          text: "사용자 권한 목록",
          link: "/userPermissions",
      },
      {
          text: "인증 로그 기록",
          link: "/authenticationLogs",
      },
      {
          text: "감사 로그",
          link: "/auditLogs",
      },
      {
          text: "로그 보관 정책",
          link: "/logRetentionPolicies",
      },
      {
          text: "로그 보관 정책",
          link: "/logRetentionPolicies",
      },
      {
          text: "감사 로그",
          link: "/auditLogs",
      },
      {
          text: "활동 로그 요약",
          link: "/activityLogSummaries",
      },
      {
          text: "감사 로그 상세 항목",
          link: "/auditLogEntries",
      },
      {
          text: "보존 정책 구성 조회",
          link: "/retentionPolicyConfigurations",
      },
      {
          text: "감사 로그 요약",
          link: "/auditLogSummaries",
      },
      {
          text: "활동 내역 조회",
          link: "/activityHistories",
      },
      {
          text: "보존 정책 구성 조회",
          link: "/retentionPolicyConfigurations",
      },
      {
          text: "비정상 활동",
          link: "/abnormalActivities",
      },
      {
          text: "",
          link: "/",
      },
      {
          text: "사용자",
          link: "/users",
      },
      {
          text: "사용자",
          link: "/users",
      },
      {
          text: "비정상 활동",
          link: "/abnormalActivities",
      },
      {
          text: "활동 탐지 설정",
          link: "/activityDetectionConfigurations",
      },
      {
          text: "사용자 상세 정보 조회",
          link: "/userDetails",
      },
      {
          text: "사용자 활동 내역 조회",
          link: "/userActivityHistories",
      },
      {
          text: "사용자 목록 조회",
          link: "/userLists",
      },
      {
          text: "비정상 활동 보고서",
          link: "/abnormalActivityReports",
      },
      {
          text: "사용자 목록",
          link: "/userLists",
      },
      {
          text: "비정상 활동 대기열",
          link: "/abnormalActivityQueues",
      },
      {
          text: "활동 탐지 보고서",
          link: "/activityDetectionReports",
      },
      {
          text: "사용자 상세",
          link: "/userDetails",
      },
      {
          text: "사용자 활동 로그",
          link: "/userActivityLogs",
      },
      {
          text: "지식 동기화",
          link: "/knowledgeSyncs",
      },
      {
          text: "동기화 실패 알림",
          link: "/syncFailureAlerts",
      },
      {
          text: "지식 동기화",
          link: "/knowledgeSyncs",
      },
      {
          text: "동기화 실패 알림",
          link: "/syncFailureAlerts",
      },
      {
          text: "지식 동기화 상태",
          link: "/knowledgeSyncStatuses",
      },
      {
          text: "활성 실패 알림 목록",
          link: "/activeFailureAlerts",
      },
      {
          text: "알림 기록",
          link: "/alertHistories",
      },
      {
          text: "동기화 이력",
          link: "/syncHistories",
      },
      {
          text: "활성 실패 알림 목록",
          link: "/activeFailureAlerts",
      },
      {
          text: "알림 기록",
          link: "/alertHistories",
      },
      {
          text: "동기화 이력 로그",
          link: "/syncHistoryLogs",
      },
      {
          text: "동기화 상태 모니터",
          link: "/syncStatusMonitors",
      },
      {
          text: "피드백 알림",
          link: "/feedbackNotifications",
      },
      {
          text: "피드백 알림 통계",
          link: "/feedbackNotificationStatistics",
      },
      {
          text: "피드백 알림 통계",
          link: "/feedbackNotificationStatistics",
      },
      {
          text: "피드백 알림",
          link: "/feedbackNotifications",
      },
      {
          text: "알림 내역",
          link: "/notificationHistories",
      },
      {
          text: "피드백 비율 요약",
          link: "/feedbackRatioSummaries",
      },
      {
          text: "알림 경고 상태",
          link: "/notificationAlertStatuses",
      },
      {
          text: "임계값 설정 정보",
          link: "/thresholdConfigurations",
      },
      {
          text: "피드백 통계 요약",
          link: "/feedbackStatisticsSummaries",
      },
      {
          text: "임계치 설정 정보",
          link: "/thresholdConfigurations",
      },
      {
          text: "알림 기록",
          link: "/notificationHistories",
      },
    ],
  }),
};
</script>
