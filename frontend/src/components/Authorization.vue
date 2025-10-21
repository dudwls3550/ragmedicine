<template>
    <div>
        <Number
            label="AuthorizationId"
            v-model="value.authorizationId"
            :editMode="editMode"
        />
        <String
            label="Role"
            v-model="value.role"
            :editMode="editMode"
        />
        <String
            label="PermissionType"
            v-model="value.permissionType"
            :editMode="editMode"
        />
        <Date
            label="GrantedAt"
            v-model="value.grantedAt"
            :editMode="editMode"
        />
        <Date
            label="RevokedAt"
            v-model="value.revokedAt"
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
        <AuthorizationStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <AuthorizationLevel
            offline
            label="Level"
            v-model="value.level"
            :editMode="editMode"
            @change="change"
        />
        <UserId
            offline
            label="사용자 ID"
            v-model="value.userId"
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
    name: 'Authorization',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "authorizations",
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
