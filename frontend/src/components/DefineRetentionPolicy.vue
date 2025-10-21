<template>

    <v-card outlined>
        <v-card-title>
            DefineRetentionPolicy
        </v-card-title>

        <v-card-text>
            <String label="PolicyName" v-model="value.policyName" :editMode="editMode"/>
            <Number label="RetentionPeriodYears" v-model="value.retentionPeriodYears" :editMode="editMode"/>
            <Boolean label="IsActive" v-model="value.isActive" :editMode="editMode"/>
            <AuditLogId offline label="AuditLogId" v-model="value.auditLogId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="defineRetentionPolicy"
            >
                DefineRetentionPolicy
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
    name: 'DefineRetentionPolicyCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.policyName = '';
        this.value.retentionPeriodYears = 0;
        this.value.isActive = false;
        this.value.auditLogId = {};
    },
    watch: {
    },
    methods: {
        defineRetentionPolicy() {
            this.$emit('defineRetentionPolicy', this.value);
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

