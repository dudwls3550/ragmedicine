<template>

    <v-card outlined>
        <v-card-title>
            UpdateRetentionPolicy
        </v-card-title>

        <v-card-text>
            <Number label="LogRetentionPolicyId" v-model="value.logRetentionPolicyId" :editMode="editMode"/>
            <String label="PolicyName" v-model="value.policyName" :editMode="editMode"/>
            <Number label="RetentionPeriodYears" v-model="value.retentionPeriodYears" :editMode="editMode"/>
            <Boolean label="IsActive" v-model="value.isActive" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateRetentionPolicy"
            >
                UpdateRetentionPolicy
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
    name: 'UpdateRetentionPolicyCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.logRetentionPolicyId = 0;
        this.value.policyName = '';
        this.value.retentionPeriodYears = 0;
        this.value.isActive = false;
    },
    watch: {
    },
    methods: {
        updateRetentionPolicy() {
            this.$emit('updateRetentionPolicy', this.value);
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

