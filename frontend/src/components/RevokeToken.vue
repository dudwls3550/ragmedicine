<template>

    <v-card outlined>
        <v-card-title>
            RevokeToken
        </v-card-title>

        <v-card-text>
            <Number label="TokenId" v-model="value.tokenId" :editMode="editMode"/>
            <String label="Reason" v-model="value.reason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="revokeToken"
            >
                RevokeToken
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
    name: 'RevokeTokenCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.tokenId = 0;
        this.value.reason = '';
    },
    watch: {
    },
    methods: {
        revokeToken() {
            this.$emit('revokeToken', this.value);
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

