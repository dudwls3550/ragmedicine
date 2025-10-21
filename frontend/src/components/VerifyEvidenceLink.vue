<template>

    <v-card outlined>
        <v-card-title>
            VerifyEvidenceLink
        </v-card-title>

        <v-card-text>
            <Number label="SourceEvidenceId" v-model="value.sourceEvidenceId" :editMode="editMode"/>
            <Date label="VerificationTimestamp" v-model="value.verificationTimestamp" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="verifyEvidenceLink"
            >
                VerifyEvidenceLink
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
    name: 'VerifyEvidenceLinkCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.sourceEvidenceId = 0;
        this.value.verificationTimestamp = '2025-10-21';
    },
    watch: {
    },
    methods: {
        verifyEvidenceLink() {
            this.$emit('verifyEvidenceLink', this.value);
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

