<template>

    <v-card outlined>
        <v-card-title>
            ValidateToken
        </v-card-title>

        <v-card-text>
            <String label="TokenValue" v-model="value.tokenValue" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="validateToken"
            >
                ValidateToken
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
    name: 'ValidateTokenCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.tokenValue = '';
    },
    watch: {
    },
    methods: {
        validateToken() {
            this.$emit('validateToken', this.value);
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

