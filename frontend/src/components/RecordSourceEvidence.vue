<template>

    <v-card outlined>
        <v-card-title>
            RecordSourceEvidence
        </v-card-title>

        <v-card-text>
            <Number label="AnswerGenerationId" v-model="value.answerGenerationId" :editMode="editMode"/>
            <EvidenceType offline label="SourceType" v-model="value.sourceType" :editMode="editMode" @change="change"/>
            <String label="SourceTitle" v-model="value.sourceTitle" :editMode="editMode"/>
            <String label="SourceUrl" v-model="value.sourceUrl" :editMode="editMode"/>
            <KnowledgeSyncId offline label="KnowledgeSyncId" v-model="value.knowledgeSyncId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="recordSourceEvidence"
            >
                RecordSourceEvidence
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
    name: 'RecordSourceEvidenceCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.answerGenerationId = 0;
        this.value.sourceType = {};
        this.value.sourceTitle = '';
        this.value.sourceUrl = '';
        this.value.knowledgeSyncId = {};
    },
    watch: {
    },
    methods: {
        recordSourceEvidence() {
            this.$emit('recordSourceEvidence', this.value);
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

