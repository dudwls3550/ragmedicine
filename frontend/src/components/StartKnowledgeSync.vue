<template>

    <v-card outlined>
        <v-card-title>
            StartKnowledgeSync
        </v-card-title>

        <v-card-text>
            <Number label="SyncId" v-model="value.syncId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="startKnowledgeSync"
            >
                StartKnowledgeSync
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'StartKnowledgeSyncCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.syncId = 0;
    },
    watch: {
    },
    methods: {
        startKnowledgeSync() {
            this.$emit('startKnowledgeSync', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

