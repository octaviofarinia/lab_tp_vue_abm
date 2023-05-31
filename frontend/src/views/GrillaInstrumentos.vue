<template>
    <p style="text-align: left; padding-left: 200px;">
        <a class="btn btn-primary" :href="'/instrumentos/formulario/0'" role="button">Nuevo</a>
    </p>
    <div class="container">
        <div class="row" style="padding-bottom: 20px;">
            <div class="col-3">
                <input type="number" v-model="filter.minPrice" placeholder="Min price" class="form-control" />
            </div>
            <div class="col-3">
                <input type="number" v-model="filter.maxPrice" placeholder="Max price" class="form-control" />
            </div>
            <div class="col-2">
                <button class="btn btn-secondary" @click="filterInstruments">Filter</button>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <b>ID</b>
            </div>
            <div class="col">
                <b>Instrumento</b>
            </div>
            <div class="col">
                <b>Marca</b>
            </div>
            <div class="col">
                <b>Modelo</b>
            </div>
            <div class="col">
                <b>Imagen</b>
            </div>
            <div class="col">
                <b>Precio</b>
            </div>
            <div class="col">
                <b>Costo Envio</b>
            </div>
            <div class="col">
                <b>Cantidad Vendida</b>
            </div>
            <div class="col">
                <b>Descripcion</b>
            </div>
            <div class="col">
                <b>Modificar</b>
            </div>
            <div class="col">
                <b>Eliminar</b>
            </div>
        </div>
        <div class="row" v-for="instrumento in instrumentosData" :key="instrumento.id" style="padding-top: 5px;">
            <div class="col">
                {{ instrumento.id }}
            </div>
            <div class="col">
                {{ instrumento.instrumento }}
            </div>
            <div class="col">
                {{ instrumento.marca }}
            </div>
            <div class="col">
                {{ instrumento.modelo }}
            </div>
            <div class="col">
                {{ instrumento.imagen }}
            </div>
            <div class="col">
                {{ instrumento.precio }}
            </div>
            <div class="col">
                {{ instrumento.costoEnvio }}
            </div>
            <div class="col">
                {{ instrumento.cantidadVendida }}
            </div>
            <div class="col">
                {{ instrumento.descripcion ? instrumento.descripcion.slice(0, 50) + "..." : '' }}
            </div>
            <div class="col">
                <a class="btn btn-primary" :href="'/instrumentos/formulario/' + instrumento.id" role="button">Modificar</a>
            </div>
            <div class="col">
                <button type="button" @click="deleteInstrumento(instrumento.id)" class="btn btn-danger">Eliminar</button>
            </div>
        </div>
    </div>
</template>
  
<script lang="ts">
import type Instrumento from '@/entidades/Instrumento';
import { defineComponent, onMounted, reactive, ref } from 'vue';

export default defineComponent({
    name: 'GrillaInstrumentos',
    components: {},
    setup() {
        const instrumentosData = ref<Instrumento[]>([])
        const filter = reactive({
            minPrice: 0,
            maxPrice: 0
        });
        onMounted(async () => {
            const res = await fetch(
                "http://localhost:8081/instrumentos", {
                method: 'GET',
                headers: {
                    'Content-type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
                },
                mode: 'cors'
            });
            const resJson = await res.json();
            console.log(resJson);
            instrumentosData.value = await resJson;
        });
        return {
            instrumentosData,
            filter
        };
    },
    methods: {
        filterInstruments: function () {
            this.instrumentosData = this.instrumentosData.filter(instrumento => {
                let price = parseFloat(instrumento.precio);
                return price >= this.filter.minPrice && price <= this.filter.maxPrice;
            });
        },
        deleteInstrumento: async function (idPlato: number) {
            let urlServer = 'http://localhost:8081/instrumentos/' + idPlato;
            console.log(urlServer);
            let result = await fetch(urlServer, {
                method: 'DELETE',
                headers: {
                    'Content-type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
                },
                mode: 'cors'
            });
            window.location.reload();
        }
    }
});
</script>
  
<style></style>