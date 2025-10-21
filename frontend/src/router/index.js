import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/feedbacks',
      component: () => import('../components/ui/FeedbackGrid.vue'),
    },
    {
      path: '/questionAnswers',
      component: () => import('../components/ui/QuestionAnswerGrid.vue'),
    },
    {
      path: '/feedbacks',
      component: () => import('../components/ui/FeedbackGrid.vue'),
    },
    {
      path: '/questionAnswers',
      component: () => import('../components/ui/QuestionAnswerGrid.vue'),
    },
    {
      path: '/answerGenerations',
      component: () => import('../components/ui/AnswerGenerationGrid.vue'),
    },
    {
      path: '/sourceEvidences',
      component: () => import('../components/ui/SourceEvidenceGrid.vue'),
    },
    {
      path: '/sourceEvidences',
      component: () => import('../components/ui/SourceEvidenceGrid.vue'),
    },
    {
      path: '/answerGenerations',
      component: () => import('../components/ui/AnswerGenerationGrid.vue'),
    },
    {
      path: '/authorizations',
      component: () => import('../components/ui/AuthorizationGrid.vue'),
    },
    {
      path: '/authenticationTokens',
      component: () => import('../components/ui/AuthenticationTokenGrid.vue'),
    },
    {
      path: '/authenticationTokens',
      component: () => import('../components/ui/AuthenticationTokenGrid.vue'),
    },
    {
      path: '/authorizations',
      component: () => import('../components/ui/AuthorizationGrid.vue'),
    },
    {
      path: '/auditLogs',
      component: () => import('../components/ui/AuditLogGrid.vue'),
    },
    {
      path: '/logRetentionPolicies',
      component: () => import('../components/ui/LogRetentionPolicyGrid.vue'),
    },
    {
      path: '/logRetentionPolicies',
      component: () => import('../components/ui/LogRetentionPolicyGrid.vue'),
    },
    {
      path: '/auditLogs',
      component: () => import('../components/ui/AuditLogGrid.vue'),
    },
    {
      path: '/abnormalActivities',
      component: () => import('../components/ui/AbnormalActivityGrid.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/abnormalActivities',
      component: () => import('../components/ui/AbnormalActivityGrid.vue'),
    },
    {
      path: '/knowledgeSyncs',
      component: () => import('../components/ui/KnowledgeSyncGrid.vue'),
    },
    {
      path: '/syncFailureAlerts',
      component: () => import('../components/ui/SyncFailureAlertGrid.vue'),
    },
    {
      path: '/knowledgeSyncs',
      component: () => import('../components/ui/KnowledgeSyncGrid.vue'),
    },
    {
      path: '/syncFailureAlerts',
      component: () => import('../components/ui/SyncFailureAlertGrid.vue'),
    },
    {
      path: '/feedbackNotifications',
      component: () => import('../components/ui/FeedbackNotificationGrid.vue'),
    },
    {
      path: '/feedbackNotificationStatistics',
      component: () => import('../components/ui/FeedbackNotificationStatisticsGrid.vue'),
    },
    {
      path: '/feedbackNotificationStatistics',
      component: () => import('../components/ui/FeedbackNotificationStatisticsGrid.vue'),
    },
    {
      path: '/feedbackNotifications',
      component: () => import('../components/ui/FeedbackNotificationGrid.vue'),
    },
  ],
})

export default router;
