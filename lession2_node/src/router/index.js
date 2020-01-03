import Vue from 'vue'
import Router from 'vue-router'

import home from '@/components/home'
import main from '@/components/main'
import detail_page from '@/components/detail_page'
import enroll from '@/components/enroll'
import logon from '@/components/logon'
import shopcar from '@/components/shopcar'
import orderpage from '@/components/orderpage'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/main',
      name: 'main',
      component: main
    },
    {
      path: '/',
      name: 'home',
      component: home
    },
    {
      path: '/detail_page',
      name: 'detail_page',
      component: detail_page
    },
    {
      path: '/orderpage',
      name: 'orderpage',
      component: orderpage
    },
    {
      path: '/enroll',
      name: 'enroll',
      component: enroll
    },
    {
      path: '/logon',
      name: 'logon',
      component: logon
    },
    {
      path: '/shopcar',
      name: 'shopcar',
      component: shopcar
    }












  ]
})
