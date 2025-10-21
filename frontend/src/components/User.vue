<template>
    <div>
        <Number
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="EncryptedPassword"
            v-model="value.encryptedPassword"
            :editMode="editMode"
        />
        <Number
            label="AbnormalActivityCount"
            v-model="value.abnormalActivityCount"
            :editMode="editMode"
        />
        <Number
            label="FeedbackDissatisfactionCount"
            v-model="value.feedbackDissatisfactionCount"
            :editMode="editMode"
        />
        <Date
            label="LastLoginAt"
            v-model="value.lastLoginAt"
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
        <Date
            label="SuspendedAt"
            v-model="value.suspendedAt"
            :editMode="editMode"
        />
        <String
            label="SuspendedReason"
            v-model="value.suspendedReason"
            :editMode="editMode"
        />
        <UserRole
            offline
            label="Role"
            v-model="value.role"
            :editMode="editMode"
            @change="change"
        />
        <UserStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <UserProfile
            offline
            label="Profile"
            v-model="value.profile"
            :editMode="editMode"
            @change="change"
        />
        <MedicalInstitutionVerification
            offline
            label="Verification"
            v-model="value.verification"
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
    name: 'User',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "users",
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
