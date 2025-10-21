<template>

    <v-card outlined>
        <v-card-title>
            RevokeAccess
        </v-card-title>

        <v-card-text>
            <Number label="AuthorizationId" v-model="value.authorizationId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="revokeAccess"
            >
                RevokeAccess
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
    name: 'RevokeAccessCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.authorizationId = 0;
    },
    watch: {
    },
    methods: {
        revokeAccess() {
            this.$emit('revokeAccess', this.value);
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

