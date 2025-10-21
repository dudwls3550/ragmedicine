<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <KnowledgeSyncStatus @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></KnowledgeSyncStatus>
            <SyncHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SyncHistory>
            <SyncHistoryLog @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SyncHistoryLog>
            <SyncStatusMonitor @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SyncStatusMonitor>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ExternalDbStatus</th>
                        <th>LastSyncedAt</th>
                        <th>SyncCycle</th>
                        <th>SyncData</th>
                        <th>SyncLog</th>
                        <th>SyncStatus</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ExternalDbStatus">{{ val.externalDbStatus }}</td>
                            <td class="whitespace-nowrap" label="LastSyncedAt">{{ val.lastSyncedAt }}</td>
                            <td class="whitespace-nowrap" label="SyncCycle">{{ val.syncCycle }}</td>
                            <td class="whitespace-nowrap" label="SyncData">{{ val.syncData }}</td>
                            <td class="whitespace-nowrap" label="SyncLog">{{ val.syncLog }}</td>
                            <td class="whitespace-nowrap" label="SyncStatus">{{ val.syncStatus }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">KnowledgeSync 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <KnowledgeSync :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">KnowledgeSync 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="SyncId" v-model="selectedRow.syncId" :editMode="true"/>
                            <String label="ExternalDbStatus" v-model="selectedRow.externalDbStatus" :editMode="true"/>
                            <Date label="LastSyncedAt" v-model="selectedRow.lastSyncedAt" :editMode="true"/>
                            <String label="SyncCycle" v-model="selectedRow.syncCycle" :editMode="true"/>
                            <String label="SyncData" v-model="selectedRow.syncData" :editMode="true"/>
                            <String label="SyncLog" v-model="selectedRow.syncLog" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <SyncStatus offline label="SyncStatus" v-model="selectedRow.syncStatus" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'knowledgeSyncGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'knowledgeSyncs',
    }),
    watch: {
    },
    methods:{
    }
}

</script>