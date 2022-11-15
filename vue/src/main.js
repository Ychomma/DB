import Vue from 'vue'
import App from './App.vue'
import router from './router'

//导入ElementUI，后面需要使用它提供的样式
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//导入全局自定义的样式
import '@/assets/global.css';


Vue.config.productionTip = false
Vue.use(ElementUI, {size: 'small'}); //使用ElementUI，可以选择尺寸：medium、small、mini


new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
