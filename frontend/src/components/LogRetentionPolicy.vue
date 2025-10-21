<template>
    <div>
        <Number
            label="LogRetentionPolicyId"
            v-model="value.logRetentionPolicyId"
            :editMode="editMode"
        />
        <String
            label="PolicyName"
            v-model="value.policyName"
            :editMode="editMode"
        />
        <Number
            label="RetentionPeriodYears"
            v-model="value.retentionPeriodYears"
            :editMode="editMode"
        />
        <Boolean
            label="IsActive"
            v-model="value.isActive"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Date
            label="UpdatedAt"
            v-model="value.updatedAt"
            :editMode="editMode"
        />
        <AuditLogId
            offline
            label="감사 로그 ID"
            v-model="value.auditLogId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'LogRetentionPolicy',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "logRetentionPolicies",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
