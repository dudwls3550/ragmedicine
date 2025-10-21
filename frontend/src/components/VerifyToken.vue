<template>

    <v-card outlined>
        <v-card-title>
            VerifyToken
        </v-card-title>

        <v-card-text>
            <Number label="TokenId" v-model="value.tokenId" :editMode="editMode"/>
            <String label="TokenValue" v-model="value.tokenValue" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="verifyToken"
            >
                VerifyToken
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
    name: 'VerifyTokenCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.tokenId = 0;
        this.value.tokenValue = '';
    },
    watch: {
    },
    methods: {
        verifyToken() {
            this.$emit('verifyToken', this.value);
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

