<template>
    <div>
        <String
            label="TokenId"
            v-model="value.tokenId"
            :editMode="editMode"
        />
        <String
            label="TokenValue"
            v-model="value.tokenValue"
            :editMode="editMode"
        />
        <Date
            label="IssuedAt"
            v-model="value.issuedAt"
            :editMode="editMode"
        />
        <Date
            label="ExpiresAt"
            v-model="value.expiresAt"
            :editMode="editMode"
        />
        <Date
            label="LastValidatedAt"
            v-model="value.lastValidatedAt"
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
        <TokenStatus
            offline
            label="Status"
            v-model="value.status"
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
    name: 'AuthenticationToken',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "authenticationTokens",
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
