<template>
<!--  <LoadingAnimationBoxShake />-->
<!--  <TypingWordsAnimation />-->
<!--  <LoadingAnimationMutiityLine />-->
<!--  <LoadingAnimationBoxRound />-->
<!--  <LoadingAnimationRound />-->
  <FadeInOutAmimation />
</template>


<script setup lang="ts">
// import CommonTable from "@/components/CommonTableComponent/CommonTable.vue";
// import ElementComponentsView from "@/components/ElementComponentsView.vue";
import {ref} from "vue";
import {ElMessage} from "element-plus";
import ElementComponentsView from "@/components/ElementComponentsView.vue";
import LoadingAnimationBoxShake from "@/components/Animation/LoadingAnimationBoxShake.vue";
import TypingWordsAnimation from "@/components/Animation/TypingWordsAnimation.vue";
import LoadingAnimationMutiityLine from "@/components/Animation/LoadingAnimationMutiityLine.vue";
import LoadingAnimationBoxRound from "@/components/Animation/LoadingAnimationBoxRound.vue";
import LoadingAnimationRound from "@/components/Animation/LoadingAnimationRound.vue";
import FadeInOutAmimation from "@/components/Animation/FadeInOutAmimation.vue";



const column = [
  {
    title: "学号",
    dataIndex: 'id',
  },
  {
    title: "姓名",
    dataIndex: 'name',

  },
  {
    title: "性别",
    width: 70,
    dataIndex: 'gender',
  },
  {
    title: "班级",
    dataIndex: 'class',
  },
  {
    title: "入学日期",
    dataIndex: 'date',
  }, {
    title: "学生状态",
    dataIndex: 'status',
  }, {
    title: "操作",
    slotName: 'operator',
    dataIndex: 'operator',
  }
]

const tableData = [{
  'id': '202000',
  'name': '学生1',
  'gender': '男',
  'class': '班级1',
  'date': '2020-05-26',
  'status': '毕业',

}, {
  'id': '202001',
  'name': '学生2',
  'gender': '女',
  'class': '班级2',
  'date': '2020-05-09',
  'status': '毕业',

}, {
  'id': '202002',
  'name': '学生3',
  'gender': '女',
  'class': '班级3',
  'date': '2020-12-07',
  'status': '在读',

}, {
  'id': '202003',
  'name': '学生4',
  'gender': '女',
  'class': '班级4',
  'date': '2021-12-14',
  'status': '在读',

}, {
  'id': '202004',
  'name': '学生5',
  'gender': '女',
  'class': '班级5',
  'date': '2020-11-06',
  'status': '在读',

}, {
  'id': '202005',
  'name': '学生6',
  'gender': '女',
  'class': '班级1',
  'date': '2022-12-20',
  'status': '在读',

}, {
  'id': '202006',
  'name': '学生7',
  'gender': '女',
  'class': '班级2',
  'date': '2020-05-15',
  'status': '毕业',

}, {
  'id': '202007',
  'name': '学生8',
  'gender': '男',
  'class': '班级3',
  'date': '2021-07-25',
  'status': '毕业',

}, {
  'id': '202008',
  'name': '学生9',
  'gender': '男',
  'class': '班级4',
  'date': '2021-03-06',
  'status': '休学',

}, {
  'id': '202009',
  'name': '学生10',
  'gender': '男',
  'class': '班级5',
  'date': '2022-04-18',
  'status': '在读',

}, {
  'id': '202010',
  'name': '学生11',
  'gender': '男',
  'class': '班级1',
  'date': '2021-03-19',
  'status': '在读',

}, {
  'id': '202011',
  'name': '学生12',
  'gender': '女',
  'class': '班级2',
  'date': '2021-01-28',
  'status': '在读',

}, {
  'id': '202012',
  'name': '学生13',
  'gender': '女',
  'class': '班级3',
  'date': '2022-09-27',
  'status': '毕业',

}, {
  'id': '202013',
  'name': '学生14',
  'gender': '女',
  'class': '班级4',
  'date': '2021-08-25',
  'status': '休学',

}, {
  'id': '202014',
  'name': '学生15',
  'gender': '女',
  'class': '班级5',
  'date': '2021-11-08',
  'status': '在读',

}, {
  'id': '202015',
  'name': '学生16',
  'gender': '女',
  'class': '班级1',
  'date': '2021-03-03',
  'status': '休学',
}, {
  'id': '202016',
  'name': '学生17',
  'gender': '女',
  'class': '班级2',
  'date': '2022-10-17',
  'status': '在读',
}, {
  'id': '202017',
  'name': '学生18',
  'gender': '男',
  'class': '班级3',
  'date': '2020-06-01',
  'status': '毕业',
}, {
  'id': '202018',
  'name': '学生19',
  'gender': '女',
  'class': '班级4',
  'date': '2021-06-20',
  'status': '在读',
}, {
  'id': '202019',
  'name': '学生20',
  'gender': '女',
  'class': '班级5',
  'date': '2022-01-21',
  'status': '休学',
}]

</script>
<style scoped>

</style>
