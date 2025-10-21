<template>

    <v-card outlined>
        <v-card-title>
            RefreshAccessToken
        </v-card-title>

        <v-card-text>
            <String label="RefreshTokenValue" v-model="value.refreshTokenValue" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="refreshAccessToken"
            >
                RefreshAccessToken
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
    name: 'RefreshAccessTokenCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.refreshTokenValue = '';
    },
    watch: {
    },
    methods: {
        refreshAccessToken() {
            this.$emit('refreshAccessToken', this.value);
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

