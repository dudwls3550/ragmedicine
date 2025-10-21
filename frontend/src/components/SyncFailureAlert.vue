<template>
    <div>
        <Number
            label="AlertId"
            v-model="value.alertId"
            :editMode="editMode"
        />
        <Number
            label="SyncId"
            v-model="value.syncId"
            :editMode="editMode"
        />
        <String
            label="FailureReason"
            v-model="value.failureReason"
            :editMode="editMode"
        />
        <Date
            label="NotifiedAt"
            v-model="value.notifiedAt"
            :editMode="editMode"
        />
        <AlertStatus
            offline
            label="AlertStatus"
            v-model="value.alertStatus"
            :editMode="editMode"
            @change="change"
        />
        <KnowledgeSyncId
            offline
            label="지식 동기화 ID"
            v-model="value.knowledgeSyncId"
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
    name: 'SyncFailureAlert',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "syncFailureAlerts",
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
