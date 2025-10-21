<template>

    <v-card outlined>
        <v-card-title>
            ConfigureAlertRecipients
        </v-card-title>

        <v-card-text>
            <Number label="SystemConfigurationId" v-model="value.systemConfigurationId" :editMode="editMode"/>
            <StringList offline label="RecipientEmails" v-model="value.recipientEmails" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="configureAlertRecipients"
            >
                ConfigureAlertRecipients
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
    name: 'ConfigureAlertRecipientsCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.systemConfigurationId = 0;
        this.value.recipientEmails = [];
    },
    watch: {
    },
    methods: {
        configureAlertRecipients() {
            this.$emit('configureAlertRecipients', this.value);
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

