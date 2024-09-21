<template>
  <el-config-provider :locale="LanguageMap[globalConfig.locale]" :size="globalConfig.size"
                      :zIndex="globalConfig.zIndex"
                      :button="{
    autoInsertSpace:globalConfig.autoInsertSpace
  }">
    <div class="container">

      <h3>按钮展示</h3>
      <el-scrollbar :height="500">
        <div class="btn-group">
          <div class="btn-group-default">
            <el-button>Default</el-button>
            <el-button type="primary">Primary</el-button>
            <el-button type="success">Success</el-button>
            <el-button type="info">Info</el-button>
            <el-button type="warning">Warning</el-button>
            <el-button type="danger">Danger</el-button>
            <el-button disabled>Default</el-button>
          </div>
          <div class="btn-group-plain">
            <el-button plain>Plain</el-button>
            <el-button type="primary" plain>Primary</el-button>
            <el-button type="success" plain>Success</el-button>
            <el-button type="info" plain>Info</el-button>
            <el-button type="warning" plain>Warning</el-button>
            <el-button type="danger" plain>Danger</el-button>
            <el-button type="primary" plain disabled>Primary</el-button>
          </div>

          <div class="btn-group-round">
            <el-button round>Round</el-button>
            <el-button type="primary" round>Primary</el-button>
            <el-button type="success" round>Success</el-button>
            <el-button type="info" round>Info</el-button>
            <el-button type="warning" round>Warning</el-button>
            <el-button type="danger" round>Danger</el-button>
            <el-button type="success" round disabled>Success</el-button>
          </div>

          <div class="btn-group-icon">
            <el-button :icon="Search" circle/>
            <el-button type="primary" :icon="Edit" circle/>
            <el-button type="success" :icon="Check" circle/>
            <el-button type="info" :icon="Message" circle/>
            <el-button type="danger" :icon="Delete" circle/>
            <el-button type="primary">
              Upload
              <el-icon class="el-icon--right">
                <Upload/>
              </el-icon>
            </el-button>
            <el-button type="danger" :icon="Star" disabled>Danger</el-button>
          </div>

          <div class="btn-group-default btn-disabled">
            <el-button disabled>Default</el-button>
            <el-button type="primary" disabled>Primary</el-button>
            <el-button type="success" disabled>Success</el-button>
            <el-button type="info" disabled>Info</el-button>
            <el-button type="warning" disabled>Warning</el-button>
            <el-button type="danger" disabled>Danger</el-button>
          </div>

          <div class="btn-group-link">

            <el-button link disabled>Default</el-button>
            <el-button type="primary" link>Primary</el-button>
            <el-button type="success" link>Success</el-button>
            <el-button type="info" link>Info</el-button>
            <el-button type="warning" link>Warning</el-button>
            <el-button type="danger" link>Danger</el-button>
            <span class="desp">链接按钮</span>
          </div>

          <div class="btn-group-text">
            <el-button text disabled>Default</el-button>
            <el-button type="primary" text>Primary</el-button>
            <el-button type="success" text>Success</el-button>
            <el-button type="info" text>Info</el-button>
            <el-button type="warning" text>Warning</el-button>
            <el-button type="danger" text>Danger</el-button>
            <span class="desp">文本按钮</span>
          </div>

          <div class="btn-group-group">
            <span class="desp">按钮组</span>
            <el-button-group>
              <el-button type="primary" :icon="ArrowLeft">Previous Page</el-button>
              <el-button type="primary">
                Next Page
                <el-icon class="el-icon--right">
                  <ArrowRight/>
                </el-icon>
              </el-button>
            </el-button-group>
            <el-button-group class="ml-4">
              <el-button type="primary" :icon="Edit"/>
              <el-button type="primary" :icon="Share"/>
              <el-button type="primary" :icon="Delete"/>
            </el-button-group>

            <span class="desp">加载按钮</span>
            <el-button type="primary" loading>Loading</el-button>
            <el-button type="primary" :loading-icon="Eleme" loading>Loading</el-button>
            <el-button type="primary" loading>
              <template #loading>
                <div class="custom-loading">
                  <svg class="circular" viewBox="-10, -10, 50, 50">
                    <path style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)" class="path"
                          d="M 30 15 L 28 17 M 25.61 25.61 A 15 15, 0, 0, 1, 15 30 A 15 15, 0, 1, 1, 27.99 7.5 L 15 15"
                    />
                  </svg>
                </div>
              </template>
              Loading
            </el-button>
          </div>

          <div class="btn-group-loading">

          </div>

          <div class="btn-group-size">
            <el-button size="large">Large</el-button>
            <el-button>Default</el-button>
            <el-button size="small">Small</el-button>
            <el-button size="large" :icon="Search" round>Search</el-button>
            <el-button :icon="Search" round>Search</el-button>
            <el-button size="small" :icon="Search" round>Search</el-button>
            <span class="desp">按钮尺寸</span>
          </div>

          <h6>自定义按钮</h6>
          <div class="btn-group-color">
            <el-button :color="customBtn.color" :disabled="customBtn.disabled" :loading="customBtn.loading"
                       :type="customBtn.type" :plain="customBtn.plain" :round="customBtn.round"
                       :circle="customBtn.circle"
                       :autofocus="customBtn.autofocus" :link="customBtn.link" :size="customBtn.size"
                       :dark="isDark">
              Default
            </el-button>
            <div>
              <el-input v-model:model-value="customBtn.color" @change="handleCustomBtnColor"
                        placeholder="输入16进制颜色">Default
              </el-input>
              <span class="desp">自定义按钮</span>
            </div>
            <div class="btn-group-color-checkbox">
              <el-checkbox v-model="customBtn.plain" label="plain"/>
              <el-checkbox v-model="customBtn.round" label="round"/>
              <el-checkbox v-model="customBtn.link" label="link"/>
              <el-checkbox v-model="customBtn.disabled" label="禁用"/>
              <el-checkbox v-model="customBtn.loading" label="加载"/>
            </div>
            <div>
              <span style="font-size: small">( 需要清除自定义颜色 )</span>
              <el-select v-model="customBtn.type" placeholder="选择按钮类型(需要清除自定义颜色)" default-first-option>
                <el-option v-for="(btnType,index) in customBtn.typeOpt" :key="index" :label="btnType" :value="btnType"/>
              </el-select>
              <el-select v-model="customBtn.size" label="size" default-first-option>
                <el-option v-for="(btnSize,index) in customBtn.sizeOpt" :key="index" :label="btnSize" :value="btnSize"/>
              </el-select>
            </div>

          </div>

        </div>
      </el-scrollbar>
      <h3>全局配置展示</h3>
      <div class="config-group">
        <div class="config-item">
          <span>语言</span>
          <el-select v-model="globalConfig.locale">
            <el-option label="中文" value="zhCn"/>
            <el-option label="en" value="en"/>
            <el-option label="ko" value="ko"/>
            <el-option label="ja" value="ja"/>
            <el-option label="nl" value="nl"/>
            <el-option label="ru" value="ru"/>
            <el-option label="ar" value="ar"/>
            <el-option label="eo" value="eo"/>
          </el-select>
        </div>
        <div class="config-item">
          <span>尺寸</span>
          <el-select v-model="globalConfig.size">
            <el-option label="large" value="large"/>
            <el-option label="default" value="default"/>
            <el-option label="small" value="small"/>
          </el-select>
        </div>
        <div class="config-item">
          <span>层级</span>
          <el-input-number v-model="globalConfig.zIndex"/>
        </div>
        <div class="config-item">
          <span>自动文字间隔填充</span>
          <el-checkbox v-model="globalConfig.button.autoInsertSpace"/>
        </div>
        <div class="config-colors">
          <div>
            <span class="demonstration">primary Color</span>
            <el-color-picker v-model="primaryColor"/>
          </div>
          <div>
            <span class="demonstration">success Color</span>
            <el-color-picker v-model="successColor"/>
          </div>
          <div>
            <span class="demonstration">warning Color</span>
            <el-color-picker v-model="warningColor"/>
          </div>
          <div>
            <span class="demonstration">danger Color</span>
            <el-color-picker v-model="dangerColor"/>
          </div>
          <div>
            <span class="demonstration">error Color</span>
            <el-color-picker v-model="errorColor"/>
          </div>
          <div>
            <span class="demonstration">info Color</span>
            <el-color-picker v-model="infoColor"/>
          </div>
        </div>
      </div>

      <h3>边框展示</h3>
      <div class="border-group">
        <table class="demo-border">
          <tbody>
          <tr>
            <td class="text">Name</td>
            <td class="text">Thickness</td>
            <td class="line">Demo</td>
          </tr>
          <tr>
            <td class="text">Solid</td>
            <td class="text">1px</td>
            <td class="line">
              <div/>
            </td>
          </tr>
          <tr>
            <td class="text">Dashed</td>
            <td class="text">2px</td>
            <td class="line">
              <div class="dashed"/>
            </td>
          </tr>
          </tbody>
        </table>
        <el-row :gutter="12" class="demo-radius">
          <el-col :span="6">
            <div class="title">No Radius</div>
            <div class="value">
              <code>
                border-radius: 0px
              </code>
            </div>
            <div class="radius" :style="{borderRadius:''}"/>
          </el-col>
          <el-col :span="6">
            <div class="title">Small Radius</div>
            <div class="value">
              <code>
                border-radius: {{ useCssVar(`--el-border-radius-small`) }}
              </code>
            </div>
            <div class="radius" :style="{borderRadius:'var(--el-border-radius-small)'}"/>
          </el-col>
          <el-col :span="6">
            <div class="title">Large Radius</div>
            <div class="value">
              <code>
                border-radius: {{ useCssVar(`--el-border-radius-large`) }}
              </code>
            </div>
            <div class="radius" :style="{borderRadius:'var(--el-border-radius-large)'}"/>
          </el-col>
          <el-col :span="6">
            <div class="title">Round Radius</div>
            <div class="value">
              <code>
                border-radius: {{ useCssVar(`--el-border-radius-round`) }}
              </code>
            </div>
            <div class="radius" :style="{borderRadius:'var(--el-border-radius-round)'}"/>
          </el-col>

        </el-row>
        <div class="border-group-shadow">
          <div class="shadow-item">
            <div :style="{
          boxShadow: `var( --el-box-shadow )`,
        }"/>
            <span class="demo-shadow-text">
        Basic Shadow
      </span>
            <code>
              --el-box-shadow
            </code>
          </div>
          <div class="shadow-item">
            <div :style="{
          boxShadow: `var( --el-box-shadow-light )`,
        }"/>
            <span class="demo-shadow-text">
        Light Shadow
      </span>
            <code>
              --el-box-shadow-light
            </code>
          </div>
          <div class="shadow-item">
            <div :style="{
          boxShadow: `var( --el-box-shadow-lighter )`,
        }"/>
            <span class="demo-shadow-text">
        Lighter Shadow
      </span>
            <code>
              --el-box-shadow-lighter
            </code>
          </div>
          <div class="shadow-item">
            <div :style="{
          boxShadow: `var( --el-box-shadow-dark )`,
        }"/>
            <span class="demo-shadow-text">
        Dark Shadow
      </span>
            <code>
              --el-box-shadow-dark
            </code>
          </div>
        </div>
      </div>
      <h3>颜色展示</h3>
      <div class="colors-group">

        <div class="colors_card" v-for="(t,index) in type" :key="index" :class="`color-${t}`">
          <div class="card_top">
            <span>Brad Color</span>
            <span>{{ useCssVar(`--el-color-${t}`) }}</span>
          </div>
          <div class="card_bottom">
            <span class="color"></span>
            <span class="color"></span>
            <span class="color"></span>
            <span class="color"></span>
            <span class="color"></span>
            <span class="color"></span>
          </div>
        </div>
      </div>
      <div class="color-others">
        <div class="others-item">
          <div class="others-item-title">Text Color</div>
          <div class="others-item-value">
            <span :style="{backgroundColor:`var( --el-text-color-primary )`}"/>
            <span :style="{backgroundColor:`var( --el-text-color-regular )`}"/>
            <span :style="{backgroundColor:`var( --el-text-color-secondary )`}"/>
            <span :style="{backgroundColor:`var( --el-text-color-placeholder )`}"/>
            <span :style="{backgroundColor:`var( --el-text-color-disabled )`}"/>
          </div>
        </div>
        <div class="others-item">
          <div class="others-item-title">border Color</div>
          <div class="others-item-value">
            <span :style="{backgroundColor:`var( --el-border-color )`}"/>
            <span :style="{backgroundColor:`var( --el-border-color-light )`}"/>
            <span :style="{backgroundColor:`var( --el-border-color-lighter )`}"/>
            <span :style="{backgroundColor:`var( --el-border-color-extra-light )`}"/>
            <span :style="{backgroundColor:`var( --el-border-color-dark )`}"/>
            <span :style="{backgroundColor:`var( --el-border-color-darker )`}"/>
          </div>
        </div>
        <div class="others-item">
          <div class="others-item-title">fill Color</div>
          <div class="others-item-value">
            <span :style="{backgroundColor:`var( --el-fill-color )`}"/>
            <span :style="{backgroundColor:`var( --el-fill-color-light )`}"/>
            <span :style="{backgroundColor:`var( --el-fill-color-lighter )`}"/>
            <span :style="{backgroundColor:`var( --el-fill-color-extra-light )`}"/>
            <span :style="{backgroundColor:`var( --el-fill-color-dark )`}"/>
            <span :style="{backgroundColor:`var( --el-fill-color-darker )`}"/>
          </div>
        </div>
      </div>
      <h3>表单展示</h3>
      <div class="form-group">
        <el-form :model="form" :rules="formConfig.rulesble?formConfig.rules:undefined"
                 :labelPosition="formConfig.labelPosition"
                 :labelSuffix="formConfig.labelSuffix" :hideRequiredAsterisk="formConfig.hideRequiredAsterisk"
                 :requireAsteriskPosition="formConfig.requireAsteriskPosition" :showMessage="formConfig.showMessage"
                 :inline-message="formConfig.inlineMessage" :status-icon="formConfig.statusIcon"
                 :validateOnRuleChange="formConfig.validateOnRuleChange"
                 :size="formConfig.size" :disabled="formConfig.disabled" :scroll-to-error="formConfig.scrollToError"
                 ref="formRef" label-width="100px"
                 :inline="formConfig.inline">

          <el-checkbox v-model="formConfig.showMessage" label="showMessage"/>
          <el-checkbox v-model="formConfig.hideRequiredAsterisk" label="hideRequiredAsterisk"/>
          <el-checkbox v-model="formConfig.inlineMessage" label="inlineMessage"/>
          <el-checkbox v-model="formConfig.statusIcon" label="statusIcon"/>
          <el-checkbox v-model="formConfig.validateOnRuleChange" label="validateOnRuleChange"/>
          <el-checkbox v-model="formConfig.disabled" label="disabled"/>
          <el-checkbox v-model="formConfig.scrollToError" label="scrollToError"/>
          <el-checkbox v-model="formConfig.inline" label="inline"/>
          <el-checkbox v-model="formConfig.rulesble" label="启用校验"/>
          <el-form-item label="自定义输入" prop="input">
            <el-input v-model="form.input" placeholder="input"/>
          </el-form-item>
          <el-form-item label="Label位置" prop="labelPosition" required>
            <el-select v-model="formConfig.labelPosition" style="min-height: 70px" default-first-option
                       placeholder="labelPosition">
              <el-option label="left" value="left"/>
              <el-option label="right" value="right"/>
              <el-option label="top" value="top"/>
            </el-select>
          </el-form-item>
          <el-form-item label="labelSuffix" prop="labelSuffix" required>
            <el-input v-model="formConfig.labelSuffix" placeholder="输入表单Label的后缀(String)"/>
          </el-form-item>
          <el-form-item label="尺寸" required>
            <el-select v-model="formConfig.size" style="min-width: 70px" default-first-option placeholder="size">
              <el-option label="空" value=""/>
              <el-option label="large" value="large"/>
              <el-option label="default" value="default"/>
              <el-option label="small" value="small"/>
            </el-select>
          </el-form-item>
          <el-form-item label="必填图标位置" required>
            <el-select v-model="formConfig.requireAsteriskPosition" default-first-option
                       placeholder="requireAsteriskPosition">
              <el-option label="left" value="left"/>
              <el-option label="right" value="right"/>
            </el-select>
          </el-form-item>
          <el-form-item label="上传">
            <el-upload list-type="picture-card"/>
          </el-form-item>
          <el-form-item label="级联选择器">
            <el-cascader v-model="form.cascader" :options="cascaderOptions"/>
          </el-form-item>
          <!--        <el-form-item label="日期时间选择器">-->
          <!--          <el-date-picker-->
          <!--              v-model="form.datetimerange"-->
          <!--              type="datetimerange"-->
          <!--              range-separator="To"-->
          <!--              start-placeholder="Start date"-->
          <!--              end-placeholder="End date"-->
          <!--          />-->
          <!--        </el-form-item>-->
          <el-form-item label="提及">
            <el-mention
                v-model="form.mention"
                :options="mentionOptions"
                placeholder="@后跟随内容"
            />
          </el-form-item>
          <el-form-item label="滑块">
            <el-rate v-model="form.rate"/>
          </el-form-item>
          <el-form-item label="横向滑块">
            <el-slider v-model="form.slider"/>
          </el-form-item>
          <el-form-item label="横向滑块">
            <el-switch v-model="form.switch"/>
          </el-form-item>
          <el-form-item label="横向滑块">
            <el-transfer v-model="form.transfer" :data="transferData"/>
          </el-form-item>

          <div class="flex items-center">
            <el-button @click="$refs.formRef?.resetFields()" type="warning">reset</el-button>
            <el-button @click="submitForm(formRef)" type="primary">submit</el-button>
          </div>
        </el-form>
      </div>
      <h3>数据展示</h3>
      <div class="data-shows">
        <el-affix target=".container" :offset="80">
          <el-button type="primary">affix</el-button>
        </el-affix>
        Scroll down to see the bottom-right button.
        <el-backtop :right="100" :bottom="100"/>
        <ul v-infinite-scroll="infiniteCountLoad" class="infinite-list" style="height:300px;overflow: auto">
          <li v-for="i in infiniteCount" :key="i" class="infinite-list-item">{{ i }}</li>
        </ul>
        <el-tabs v-model="tabsName" class="demo-tabs" @tab-click="tabsHandleClick" style="min-height: 300px">
          <el-tab-pane label="步骤器" name="first">
            <el-steps style="max-width: 600px" :active="stepsActive" finish-status="success">
              <el-step title="Step 1"/>
              <el-step title="Step 2"/>
              <el-step title="Step 3"/>
            </el-steps>
            <el-button style="margin-top: 12px" @click="stepsNext">Next step</el-button>
          </el-tab-pane>
          <el-tab-pane label="页头" name="second">
            <div aria-label="A complete example of page header">
              <el-page-header>
                <template #breadcrumb>
                  <el-breadcrumb separator="/">
                    <el-breadcrumb-item :to="{ path: '/' }">
                      homepage
                    </el-breadcrumb-item>
                    <el-breadcrumb-item>
                      route 1
                    </el-breadcrumb-item>
                    <el-breadcrumb-item>route 2</el-breadcrumb-item>
                  </el-breadcrumb>
                </template>
                <template #content>
                  <div class="flex items-center">
                    <el-avatar
                        class="mr-3"
                        :size="32"
                        :src="url"
                    />
                    <span class="text-large font-600 mr-3"> Title </span>
                    <span
                        class="text-sm mr-2"
                        style="color: var(--el-text-color-regular)"
                    >
            Sub title
          </span>
                    <el-tag>Default</el-tag>
                  </div>
                </template>
                <template #extra>
                  <div class="flex items-center">
                    <el-button>Print</el-button>
                    <el-button type="primary" class="ml-2">Edit</el-button>
                  </div>
                </template>

                <el-descriptions :column="3" size="small" class="mt-4">
                  <el-descriptions-item label="Username">
                    kooriookami
                  </el-descriptions-item>
                  <el-descriptions-item label="Telephone">
                    18100000000
                  </el-descriptions-item>
                  <el-descriptions-item label="Place">Suzhou</el-descriptions-item>
                  <el-descriptions-item label="Remarks">
                    <el-tag size="small">School</el-tag>
                  </el-descriptions-item>
                  <el-descriptions-item label="Address">
                    No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province
                  </el-descriptions-item>
                </el-descriptions>
                <p class="mt-4 text-sm">
                  Element Plus team uses <b>weekly</b> release strategy under normal
                  circumstance, but critical bug fixes would require hotfix so the actual
                  release number <b>could be</b> more than 1 per week.
                </p>
              </el-page-header>
            </div>
          </el-tab-pane>
          <el-tab-pane label="菜单" name="third">
            <el-menu
                class="el-menu-demo"
                mode="horizontal"
            >
              <el-menu-item index="1">Processing Center</el-menu-item>
              <el-sub-menu index="2">
                <template #title>Workspace</template>
                <el-menu-item index="2-1">item one</el-menu-item>
                <el-menu-item index="2-2">item two</el-menu-item>
                <el-menu-item index="2-3">item three</el-menu-item>
                <el-sub-menu index="2-4">
                  <template #title>item four</template>
                  <el-menu-item index="2-4-1">item one</el-menu-item>
                  <el-menu-item index="2-4-2">item two</el-menu-item>
                  <el-menu-item index="2-4-3">item three</el-menu-item>
                </el-sub-menu>
              </el-sub-menu>
              <el-menu-item index="3" disabled>Info</el-menu-item>
              <el-menu-item index="4">Orders</el-menu-item>
            </el-menu>
          </el-tab-pane>
          <el-tab-pane label="下拉框" name="fourth">
            <el-dropdown>
    <span class="el-dropdown-link">
      Dropdown List
      <el-icon class="el-icon--right">
        <arrow-down/>
      </el-icon>
    </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>Action 1</el-dropdown-item>
                  <el-dropdown-item>Action 2</el-dropdown-item>
                  <el-dropdown-item>Action 3</el-dropdown-item>
                  <el-dropdown-item disabled>Action 4</el-dropdown-item>
                  <el-dropdown-item divided>Action 5</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </el-tab-pane>
          <el-tab-pane label="面包屑" name="fifth">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">面包屑</el-breadcrumb-item>
              <el-breadcrumb-item>面包屑</el-breadcrumb-item>
            </el-breadcrumb>
          </el-tab-pane>
          <el-tab-pane label="统计" name="sixth">
            <el-row>
              <el-col :span="6">
                <el-statistic title="Daily active users" :value="268500"/>
              </el-col>
              <el-col :span="6">
                <el-statistic :value="138">
                  <template #title>
                    <div style="display: inline-flex; align-items: center">
                      Ratio of men to women
                      <el-icon style="margin-left: 4px" :size="12">
                        <Male/>
                      </el-icon>
                    </div>
                  </template>
                  <template #suffix>/100</template>
                </el-statistic>
              </el-col>
              <el-col :span="6">
                <el-statistic title="Total Transactions" :value="111"/>
              </el-col>
              <el-col :span="6">
                <el-statistic title="Feedback number" :value="562">
                  <template #suffix>
                    <el-icon style="vertical-align: -0.125em">
                      <ChatLineRound/>
                    </el-icon>
                  </template>
                </el-statistic>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="时间线" name="seventh">
            <el-timeline style="max-width: 600px">
              <el-timeline-item timestamp="2018-04-15">1</el-timeline-item>
              <el-timeline-item timestamp="2018-04-16">2</el-timeline-item>
              <el-timeline-item timestamp="2018-04-17">3</el-timeline-item>
            </el-timeline>
          </el-tab-pane>
          <el-tab-pane label="漫游式引导" name="eighth">
            <el-button @click="open=true">漫游式 引导</el-button>

            <el-button ref="ref1">Upload</el-button>
            <el-button ref="ref2" type="primary">Save</el-button>
            <el-button ref="ref3" :icon="MoreFilled"/>

            <el-tour v-model="open">
              <el-tour-step :target="ref1?.$el" title="Upload File">
                <div>Put you files here.</div>
              </el-tour-step>
              <el-tour-step
                  :target="ref2?.$el"
                  title="Save"
                  description="Save your changes"
              />
              <el-tour-step
                  :target="ref3?.$el"
                  title="Other Actions"
                  description="Click to see other"
              />
            </el-tour>
          </el-tab-pane>
          <el-tab-pane label="骨架屏" name="skeleton">
            <el-skeleton/>
            <el-skeleton style="--el-skeleton-circle-size: 100px">
              <template #template>
                <el-skeleton-item variant="circle"/>
              </template>
            </el-skeleton>
          </el-tab-pane>
          <el-tab-pane label="结果" name="result">
            <el-row>
              <el-col :sm="12" :lg="6">
                <el-result
                    icon="success"
                    title="Success Tip"
                    sub-title="Please follow the instructions"
                >
                  <template #extra>
                    <el-button type="primary">Back</el-button>
                  </template>
                </el-result>
              </el-col>
              <el-col :sm="12" :lg="6">
                <el-result
                    icon="warning"
                    title="Warning Tip"
                    sub-title="Please follow the instructions"
                >
                  <template #extra>
                    <el-button type="primary">Back</el-button>
                  </template>
                </el-result>
              </el-col>
              <el-col :sm="12" :lg="6">
                <el-result
                    icon="error"
                    title="Error Tip"
                    sub-title="Please follow the instructions"
                >
                  <template #extra>
                    <el-button type="primary">Back</el-button>
                  </template>
                </el-result>
              </el-col>
              <el-col :sm="12" :lg="6">
                <el-result icon="info" title="Info Tip">
                  <template #sub-title>
                    <p>Using slot as subtitle</p>
                  </template>
                  <template #extra>
                    <el-button type="primary">Back</el-button>
                  </template>
                </el-result>
              </el-col>
            </el-row>
          </el-tab-pane>

        </el-tabs>
        <el-tabs v-model="tabsName2" class="demo-tabs" @tab-click="tabsHandleClick" style="min-height: 300px">
          <el-tab-pane label="collapse" name="collapse">
            <el-collapse v-model="activeCollapseNames">
              <el-collapse-item title="折叠面板1" name="1">
                <div>
                  Consistent with real life: in line with the process and logic of real
                  life, and comply with languages and habits that the users are used to;
                </div>
                <div>
                  Consistent within interface: all elements should be consistent, such
                  as: design style, icons and texts, position of elements, etc.
                </div>
              </el-collapse-item>
              <el-collapse-item title="折叠面板2" name="2">
                <div>
                  Operation feedback: enable the users to clearly perceive their
                  operations by style updates and interactive effects;
                </div>
                <div>
                  Visual feedback: reflect current state by updating or rearranging
                  elements of the page.
                </div>
              </el-collapse-item>
            </el-collapse>
          </el-tab-pane>
          <el-tab-pane label="progress" name="progress">
            <div class="demo-progress">
              <el-progress :percentage="50"/>
              <el-progress :percentage="100" status="success"/>
              <el-progress :percentage="100" status="warning"/>
              <el-progress :percentage="50" status="exception"/>
            </div>
          </el-tab-pane>
          <el-tab-pane label="table" name="table">
            <el-table :data="tableData" style="width: 100%">
              <el-table-column prop="date" label="Date" width="180"/>
              <el-table-column prop="name" label="Name" width="180"/>
              <el-table-column prop="address" label="Address"/>
            </el-table>
          </el-tab-pane>
          <el-tab-pane label="tags" name="tags">
            <div class="demo-tags">
              <el-tag type="primary">Tag 1</el-tag>
              <el-tag type="success">Tag 2</el-tag>
              <el-tag type="info">Tag 3</el-tag>
              <el-tag type="warning">Tag 4</el-tag>
              <el-tag type="danger">Tag 5</el-tag>
            </div>
          </el-tab-pane>
          <el-tab-pane label="segmented" name="segmented">
            <div class="flex flex-col items-start gap-4">
              <el-segmented v-model="segmentedVal" :options="segmentedOptions" size="large"/>
            </div>
          </el-tab-pane>
          <el-tab-pane label="avatar" name="avatar">
            <el-row class="demo-avatar demo-basic">
              <el-col :span="12">
                <div class="sub-title">circle</div>
                <div class="demo-basic--circle">
                  <div class="block">
                    <el-avatar :size="50" :src="circleUrl"/>
                  </div>
                  <div v-for="size in sizeList" :key="size" class="block">
                    <el-avatar :size="size" :src="circleUrl"/>
                  </div>
                </div>
              </el-col>
              <el-col :span="12">
                <div class="sub-title">square</div>
                <div class="demo-basic--circle">
                  <div class="block">
                    <el-avatar shape="square" :size="50" :src="squareUrl"/>
                  </div>
                  <div v-for="size in sizeList" :key="size" class="block">
                    <el-avatar shape="square" :size="size" :src="squareUrl"/>
                  </div>
                </div>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="card" name="card">
            <el-card style="width: 100%">
              <template #header>
                <div class="card-header">
                  <span>Card carousel </span>
                </div>
              </template>
              <!--        <el-calendar v-model="value"/>-->
              <el-carousel height="150px">
                <el-carousel-item v-for="item in 4" :key="item">
                  <h3 class="small justify-center">{{ item }}</h3>
                </el-carousel-item>
              </el-carousel>
            </el-card>
          </el-tab-pane>
          <el-tab-pane label="badge" name="badge">
            <el-row class="">
              <el-badge :value="12" class="item">
                <el-button>comments</el-button>
              </el-badge>
              <el-badge :value="3" class="item">
                <el-button>replies</el-button>
              </el-badge>
              <el-badge :value="1" class="item" type="primary">
                <el-button>comments</el-button>
              </el-badge>
              <el-badge :value="2" class="item" type="warning">
                <el-button>replies</el-button>
              </el-badge>
              <el-badge :value="1" class="item" color="green">
                <el-button>custom background</el-button>
              </el-badge>
              <el-dropdown trigger="click">
    <span class="el-dropdown-link">
      Click Me
      <el-icon class="el-icon--right"><CaretBottom/></el-icon>
    </span>
                <template #dropdown>
                  <el-dropdown-menu>
                    <el-dropdown-item class="clearfix">
                      comments
                      <el-badge class="mark" :value="12"/>
                    </el-dropdown-item>
                    <el-dropdown-item class="clearfix">
                      replies
                      <el-badge class="mark" :value="3"/>
                    </el-dropdown-item>
                  </el-dropdown-menu>
                </template>
              </el-dropdown>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="descriptions" name="descriptions">
            <el-descriptions
                title="描述面板"
                direction="vertical"
                border
                style="margin-top: 20px"
            >
              <el-descriptions-item
                  :rowspan="2"
                  :width="140"
                  label="Photo"
                  align="center"
              >
                <el-image
                    style="width: 100px; height: 100px"
                    :src="url"
                />
              </el-descriptions-item>
              <el-descriptions-item label="Username">kooriookami</el-descriptions-item>
              <el-descriptions-item label="Telephone">18100000000</el-descriptions-item>
              <el-descriptions-item label="Place">Suzhou</el-descriptions-item>
              <el-descriptions-item label="Remarks">
                <el-tag size="small">School</el-tag>
              </el-descriptions-item>
              <el-descriptions-item label="Address">
                No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province
              </el-descriptions-item>
            </el-descriptions>
          </el-tab-pane>
          <el-tab-pane label="image" name="image">
            <div class="demo-image">
              <div v-for="fit in fits" :key="fit" class="block">
                <span class="demonstration">{{ fit }}</span>
                <el-image style="width: 100px; height: 100px" :preview-src-list="[url]" :src="url" :fit="fit"/>
              </div>
            </div>
          </el-tab-pane>
        </el-tabs>

      </div>
      <h3>反馈展示</h3>
      <div class="alert-shows">
        <div style="max-width: 300px">
          <el-alert title="Success alert" type="success"/>
          <el-alert title="Info alert" type="info"/>
          <el-alert title="Warning alert" type="warning"/>
          <el-alert title="Error alert" type="error"/>
        </div>
        <div style="max-width: 600px">
          <el-alert title="Success alert" type="success" effect="dark"/>
          <el-alert title="Info alert" type="info" effect="dark"/>
          <el-alert title="Warning alert" type="warning" effect="dark"/>
          <el-alert title="Error alert" type="error" effect="dark"/>
        </div>
        <el-button @click="dialogVisible = true">
          Click to open the Dialog
        </el-button>
        <el-button @click="drawer = true"> Click to open the drawer</el-button>
        <div class="flex justify-center w-full">
          <el-radio-group v-model="drawenDirection">
            <el-radio value="ltr">left to right</el-radio>
            <el-radio value="rtl">right to left</el-radio>
            <el-radio value="ttb">top to bottom</el-radio>
            <el-radio value="btt">bottom to top</el-radio>
          </el-radio-group>
        </div>
        <div class="flex justify-center w-full">
          <el-button @click="openElmessage">Open Message</el-button>
          <el-button @click="openElmessageVn">Open Message VNode</el-button>
          <el-button plain @click="openMessageBox">Click to open the Message Box</el-button>
          <el-button plain @click="openElNotification"> Won't close automatically</el-button>

        </div>
        <div class="flex justify-center w-full">
          <el-button plain @click="openElNotificationByType('success')"> Success</el-button>
          <el-button plain @click="openElNotificationByType('warning')"> Warning</el-button>
          <el-button plain @click="openElNotificationByType('info')"> Info</el-button>
          <el-button plain @click="openElNotificationByType('error')"> Error</el-button>
        </div>
        <div class="flex justify-center w-full">
          <el-popconfirm title="Are you sure to delete this?">
            <template #reference>
              <el-button>气泡确认框</el-button>
            </template>
          </el-popconfirm>
        </div>
        <div class="flex justify-center w-full">
          <el-popover
              placement="top-start"
              title="Title"
              :width="200"
              trigger="hover"
              content="this is content, this is content, this is content"
          >
            <template #reference>
              <el-button class="m-2">Hover to activate</el-button>
            </template>
          </el-popover>

          <el-popover
              placement="bottom"
              title="Title"
              :width="200"
              trigger="click"
              content="this is content, this is content, this is content"
          >
            <template #reference>
              <el-button class="m-2">Click to activate</el-button>
            </template>
          </el-popover>

          <el-popover
              ref="popover"
              placement="right"
              title="Title"
              :width="200"
              trigger="focus"
              content="this is content, this is content, this is content"
          >
            <template #reference>
              <el-button class="m-2">Focus to activate</el-button>
            </template>
          </el-popover>

          <el-popover
              ref="popover"
              title="Title"
              :width="200"
              trigger="contextmenu"
              content="this is content, this is content, this is content"
          >
            <template #reference>
              <el-button class="m-2">contextmenu to activate</el-button>
            </template>
          </el-popover>

          <el-popover
              :visible="visible"
              placement="bottom"
              title="Title"
              :width="200"
              content="this is content, this is content, this is content"
          >
            <template #reference>
              <el-button class="m-2" @click="visible = !visible">
                Manual to activate
              </el-button>
            </template>
          </el-popover>
        </div>
        <div class="tooltip-base-box">
          <div class="row center">
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Top Left prompts info"
                placement="top-start"
            >
              <el-button>top-start</el-button>
            </el-tooltip>
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Top Center prompts info"
                placement="top"
            >
              <el-button>top</el-button>
            </el-tooltip>
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Top Right prompts info"
                placement="top-end"
            >
              <el-button>top-end</el-button>
            </el-tooltip>
          </div>
          <div class="row">
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Left Top prompts info"
                placement="left-start"
            >
              <el-button>left-start</el-button>
            </el-tooltip>
            <span>文字tooltip</span>
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Right Top prompts info"
                placement="right-start"
            >
              <el-button>right-start</el-button>
            </el-tooltip>
          </div>
          <div class="row">
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Left Center prompts info"
                placement="left"
            >
              <el-button class="mt-3 mb-3">left</el-button>
            </el-tooltip>
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Right Center prompts info"
                placement="right"
            >
              <el-button>right</el-button>
            </el-tooltip>
          </div>
          <div class="row">
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Left Bottom prompts info"
                placement="left-end"
            >
              <el-button>left-end</el-button>
            </el-tooltip>
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Right Bottom prompts info"
                placement="right-end"
            >
              <el-button>right-end</el-button>
            </el-tooltip>
          </div>
          <div class="row center">
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Bottom Left prompts info"
                placement="bottom-start"
            >
              <el-button>bottom-start</el-button>
            </el-tooltip>
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Bottom Center prompts info"
                placement="bottom"
            >
              <el-button>bottom</el-button>
            </el-tooltip>
            <el-tooltip
                class="box-item"
                effect="dark"
                content="Bottom Right prompts info"
                placement="bottom-end"
            >
              <el-button>bottom-end</el-button>
            </el-tooltip>
          </div>
        </div>
      </div>
      <h3>其他</h3>
      <div class="others-others">
        <span>What you are you do not see, what you see is your shadow. </span>
        <el-divider content-position="left">Rabindranath Tagore</el-divider>
        <span>
      My wishes are fools, they shout across thy song, my Master. Let me but
      listen.
    </span>
        <el-divider>
          <el-icon>
            <star-filled/>
          </el-icon>
        </el-divider>
        <span>I cannot choose the best. The best chooses me.</span>
        <el-divider content-position="right">Rabindranath Tagore</el-divider>
      </div>
      <div class="water-container">
        <el-watermark
            class="watermark"
            :content="waterConfig.content"
            :font="waterConfig.font"
            :z-index="waterConfig.zIndex"
            :rotate="waterConfig.rotate"
            :gap="waterConfig.gap"
            :offset="waterConfig.offset"
        />
        <div class="water-container-form-container">
          <el-form :model="waterConfig">
            <el-form-item label="Content">
              <el-input v-model="waterConfig.content"/>
            </el-form-item>
            <el-form-item label="Color">
              <el-color-picker v-model="waterConfig.font.color" show-alpha/>
            </el-form-item>
            <el-form-item label="FontSize">
              <el-slider v-model="waterConfig.font.fontSize"/>
            </el-form-item>
            <el-form-item label="zIndex">
              <el-slider v-model="waterConfig.zIndex"/>
            </el-form-item>
            <el-form-item label="Rotate">
              <el-slider v-model="waterConfig.rotate" :min="-180" :max="180"/>
            </el-form-item>
            <el-form-item label="Gap">
              <el-space>
                <el-input-number v-model="waterConfig.gap[0]" controls-position="right"/>
                <el-input-number v-model="waterConfig.gap[1]" controls-position="right"/>
              </el-space>
            </el-form-item>
            <el-form-item label="Offset">
              <el-space>
                <el-input-number
                    v-model="waterConfig.offset[0]"
                    placeholder="offsetLeft"
                    controls-position="right"
                />
                <el-input-number
                    v-model="waterConfig.offset[1]"
                    placeholder="offsetTop"
                    controls-position="right"
                />
              </el-space>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
    <el-drawer
        v-model="drawer"
        title="I am the title"
        :direction="drawenDirection"
    >
      <span>Hi, there!</span>
    </el-drawer>
    <el-dialog
        v-model="dialogVisible"
        width="500">
      <template #header>
        <span>Dialog header slot</span>
      </template>
      <template #default>
        <p>Dialog default slot</p>
      </template>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="dialogVisible = false">
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>
  </el-config-provider>
</template>


<script setup lang="ts">
import {
  ArrowLeft, ArrowRight, Share, Eleme, MoreFilled, Male, ChatLineRound,
  Check, Delete, Edit, Message, Search, Star, Upload, CaretBottom, ArrowDown,
} from '@element-plus/icons-vue'
import {computed, reactive, ref, toRefs, h} from "vue";
import {useCssVar} from "@vueuse/core";
import {FormInstance, ImageProps, TabsPaneContext, ElMessage, ElMessageBox, Action, ElNotification} from "element-plus";
import {Option} from "element-plus/es/components/segmented/src/types";
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import en from 'element-plus/es/locale/lang/en'
import ko from 'element-plus/es/locale/lang/ko'
import ja from 'element-plus/es/locale/lang/ja'
import nl from 'element-plus/es/locale/lang/nl'
import ar from 'element-plus/es/locale/lang/ar'
import eo from 'element-plus/es/locale/lang/eo'
import ru from 'element-plus/es/locale/lang/ru'

const visible = ref(false)
const url = 'https://fuss10.elemecdn.com/e/12d/4a731a90594a4af544c0c25941171jpeg.jpeg'

const LanguageMap = {
  zhCn: zhCn,
  en: en,
  ko: ko,
  ja: ja,
  nl: nl,
  ru: ru,
  ar: ar,
  eo: eo,
}


const globalConfig = ref({
  locale: 'zh-cn',
  size: 'large',
  zIndex: 2000,
  button: {
    autoInsertSpace: false
  },
  message: {
    max: 7,
    grouping: 3,
    duration: 3000
  },
  emptyValues: [],
})

const primaryColor = computed({
  get: () => getCSSVariable('--el-color-primary'),
  set: (val) => setCSSVariable('--el-color-primary', val)
})
const successColor = computed({
  get: () => getCSSVariable('--el-color-success'),
  set: (val) => setCSSVariable('--el-color-success', val)
})
const warningColor = computed({
  get: () => getCSSVariable('--el-color-warning'),
  set: (val) => setCSSVariable('--el-color-warning', val)
})
const dangerColor = computed({
  get: () => getCSSVariable('--el-color-danger'),
  set: (val) => setCSSVariable('--el-color-danger', val)
})
const errorColor = computed({
  get: () => getCSSVariable('--el-color-error'),
  set: (val) => setCSSVariable('--el-color-error', val)
})
const infoColor = computed({
  get: () => getCSSVariable('--el-color-info'),
  set: (val) => setCSSVariable('--el-color-info', val)
})


function setCSSVariable(propertyName, value) {
  document.documentElement.style.setProperty(propertyName, value);
}

function getCSSVariable(propertyName) {
  return getComputedStyle(document.documentElement).getPropertyValue(propertyName);
}

const openElNotification = () => {
  ElNotification({
    title: 'Title',
    message: h('i', {style: 'color: teal'}, 'This is a reminder'),
  })
}
const openElNotificationByType = (type: string) => {
  ElNotification({
    title: type,
    message: 'This is a success message',
    type: type,
  })
}


const waterConfig = ref({
  content: 'watermark',
  font: {
    fontSize: 16,
    color: 'rgba(0, 0, 0, 0.15)',
  },
  zIndex: -1,
  rotate: -22,
  gap: [100, 100],
  offset: [],
})
const openElmessage = () => {
  ElMessage('This is a message.')
}
const openMessageBox = () => {
  ElMessageBox.alert('This is a message', 'Title', {
    // if you want to disable its autofocus
    // autofocus: false,
    confirmButtonText: 'OK',
    callback: (action: Action) => {
      ElMessage({
        type: 'info',
        message: `action: ${action}`,
      })
    },
  })
}
const openElmessageVn = () => {
  ElMessage({
    message: h('p', {style: 'line-height: 1; font-size: 14px'}, [
      h('span', null, 'Message can be '),
      h('i', {style: 'color: teal'}, 'VNode'),
    ]),
  })
}
const drawer = ref(false)
const drawenDirection = ref("ltr")
const dialogVisible = ref(false)
const tabsName = ref('first')
const tabsName2 = ref('collapse')
const tabsHandleClick = (tab: TabsPaneContext, event: Event) => {
  console.log(tab, event)
}

const stepsActive = ref(0)
const stepsNext = () => {
  if (stepsActive.value++ > 2) stepsActive.value = 0
}
const segmentedVal = ref('Mon')
const segmentedOptions = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
const ref1 = ref<HTMLElement>()
const ref2 = ref<HTMLElement>()
const ref3 = ref<HTMLElement>()

const open = ref(false)


const infiniteCount = ref(0)
const infiniteCountLoad = () => {
  infiniteCount.value += 2
}

const fits = [
  'fill',
  'contain',
  'cover',
  'none',
  'scale-down',
] as ImageProps['fit'][]

const activeCollapseNames = ref(['1'])
const formRef = ref(null)
const isDark = computed(() => isDarkMode())
const screenHeight = window.innerHeight
const type = ['primary', 'success', 'info', 'warning', 'danger']
const currentDate = ref(new Date())
const value = ref(new Date())
const customBtn = ref({
  disabled: false,
  loading: false,
  link: false,
  circle: false,
  color: "#626aef",
  autofocus: false,
  type: "",
  plain: false,
  round: false,
  size: 'default',
  sizeOpt: ['default', 'large', 'small'],
  typeOpt: [
    "", "text", "default", "success", "warning", "info", "primary", "danger"
  ]
})
const handleCustomBtnColor = (val) => {

}

function isDarkMode() {
  // 检查<html>元素是否包含'dark'类
  return document.documentElement.classList.contains('dark');
}

const generateData = () => {
  const data: Option[] = []
  for (let i = 1; i <= 15; i++) {
    data.push({
      key: i,
      label: `Option ${i}`,
      disabled: i % 4 === 0,
    })
  }
  return data
}
const state = reactive({
  circleUrl:
      'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
  squareUrl:
      'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',
  sizeList: ['small', '', 'large'] as const,
})
const {circleUrl, squareUrl, sizeList} = toRefs(state)
const transferData = ref<Option[]>(generateData())
const form = ref({
  input: '',
  select: '',
  mention: '',
  radio: '',
  checkbox: [],
  switch: false,
  slider: 0,
  date: '',
  time: '',
  rate: 0,
  color: '',
  cascader: [],
  transfer: [],
  datetimerange: [],
  slider: 0,
  switch: false,

})
const rules = ref({})

const formConfig = ref({
  rules: rules,
  inline: false,
  labelPosition: 'left',
  labelSuffix: '',
  hideRequiredAsterisk: false,
  requireAsteriskPosition: 'left',
  showMessage: true,
  inlineMessage: false,
  statusIcon: false,
  validateOnRuleChange: true,
  size: '',
  disabled: false,
  scrollToError: false,
  rulesble: false,
  inputType: '',
})


const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!')
    }
  })
}

const cascaderOptions = [
  {
    value: 'guide',
    label: 'Guide',
    children: [
      {
        value: 'disciplines',
        label: 'Disciplines',
        children: [
          {
            value: 'consistency',
            label: 'Consistency',
          },
          {
            value: 'feedback',
            label: 'Feedback',
          },
          {
            value: 'efficiency',
            label: 'Efficiency',
          },
          {
            value: 'controllability',
            label: 'Controllability',
          },
        ],
      },
      {
        value: 'navigation',
        label: 'Navigation',
        children: [
          {
            value: 'side nav',
            label: 'Side Navigation',
          },
          {
            value: 'top nav',
            label: 'Top Navigation',
          },
        ],
      },
    ],
  },
  {
    value: 'component',
    label: 'Component',
    children: [
      {
        value: 'basic',
        label: 'Basic',
        children: [
          {
            value: 'layout',
            label: 'Layout',
          },
          {
            value: 'color',
            label: 'Color',
          },
          {
            value: 'typography',
            label: 'Typography',
          },
          {
            value: 'icon',
            label: 'Icon',
          },
          {
            value: 'button',
            label: 'Button',
          },
        ],
      },
      {
        value: 'form',
        label: 'Form',
        children: [
          {
            value: 'radio',
            label: 'Radio',
          },
          {
            value: 'checkbox',
            label: 'Checkbox',
          },
          {
            value: 'input',
            label: 'Input',
          },
          {
            value: 'input-number',
            label: 'InputNumber',
          },
          {
            value: 'select',
            label: 'Select',
          },
          {
            value: 'cascader',
            label: 'Cascader',
          },
          {
            value: 'switch',
            label: 'Switch',
          },
          {
            value: 'slider',
            label: 'Slider',
          },
          {
            value: 'time-picker',
            label: 'TimePicker',
          },
          {
            value: 'date-picker',
            label: 'DatePicker',
          },
          {
            value: 'datetime-picker',
            label: 'DateTimePicker',
          },
          {
            value: 'upload',
            label: 'Upload',
          },
          {
            value: 'rate',
            label: 'Rate',
          },
          {
            value: 'form',
            label: 'Form',
          },
        ],
      },
      {
        value: 'data',
        label: 'Data',
        children: [
          {
            value: 'table',
            label: 'Table',
          },
          {
            value: 'tag',
            label: 'Tag',
          },
          {
            value: 'progress',
            label: 'Progress',
          },
          {
            value: 'tree',
            label: 'Tree',
          },
          {
            value: 'pagination',
            label: 'Pagination',
          },
          {
            value: 'badge',
            label: 'Badge',
          },
        ],
      },
      {
        value: 'notice',
        label: 'Notice',
        children: [
          {
            value: 'alert',
            label: 'Alert',
          },
          {
            value: 'loading',
            label: 'Loading',
          },
          {
            value: 'message',
            label: 'Message',
          },
          {
            value: 'message-box',
            label: 'MessageBox',
          },
          {
            value: 'notification',
            label: 'Notification',
          },
        ],
      },
      {
        value: 'navigation',
        label: 'Navigation',
        children: [
          {
            value: 'menu',
            label: 'Menu',
          },
          {
            value: 'tabs',
            label: 'Tabs',
          },
          {
            value: 'breadcrumb',
            label: 'Breadcrumb',
          },
          {
            value: 'dropdown',
            label: 'Dropdown',
          },
          {
            value: 'steps',
            label: 'Steps',
          },
        ],
      },
      {
        value: 'others',
        label: 'Others',
        children: [
          {
            value: 'dialog',
            label: 'Dialog',
          },
          {
            value: 'tooltip',
            label: 'Tooltip',
          },
          {
            value: 'popover',
            label: 'Popover',
          },
          {
            value: 'card',
            label: 'Card',
          },
          {
            value: 'carousel',
            label: 'Carousel',
          },
          {
            value: 'collapse',
            label: 'Collapse',
          },
        ],
      },
    ],
  },
  {
    value: 'resource',
    label: 'Resource',
    children: [
      {
        value: 'axure',
        label: 'Axure Components',
      },
      {
        value: 'sketch',
        label: 'Sketch Templates',
      },
      {
        value: 'docs',
        label: 'Design Documentation',
      },
    ],
  },
]
const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]

const mentionOptions = ref([
  {
    label: 'Fuphoenixes',
    value: 'Fuphoenixes',
  },
  {
    label: 'kooriookami',
    value: 'kooriookami',
  },
  {
    label: 'Jeremy',
    value: 'Jeremy',
  },
  {
    label: 'btea',
    value: 'btea',
  },
])
</script>
<style scoped lang="scss">
.flex {
  display: flex;
}

.flex-wrap {
  @extend .flex;
  flex-wrap: wrap;
}

.items-center {
  @extend .flex;
  align-items: center;
}

.justify-center {
  @extend .flex;
  justify-items: center;
}

.btn-group {
  width: 100%;
  display: grid;
  gap: 12px;
}

[class^="btn-group-"] {
  display: grid;
  // 这里写上你想要应用的样式
  grid-template-columns: repeat(7, 1fr);
  gap: 10px;
  justify-content: center;
}

.btn-group-group {
  width: 100%;
  display: flex;
}

.desp {
  font-size: 10px;
}

.btn-group-color-checkbox {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
}


.demo-border {
  width: 100%;

  .text {
    width: 15%;
  }

  .line {
    width: 70%;
  }

  .line div {
    width: 100%;
    height: 0;
    border-top: 1px solid var(--el-border-color);
  }

  .line .dashed {
    border-top: 2px dashed var(--el-border-color);
  }
}

.border-group {
  border: rgba(208, 208, 208, 0.84) 1px solid;
  padding: 20px;
}

.demo-radius {
  .title {
    color: var(--el-text-color-regular);
    font-size: 18px;
    margin: 10px 0;
  }

  .value {
    color: var(--el-text-color-primary);
    font-size: 16px;
    margin: 10px 0;
  }

  .radius {
    height: 40px;
    width: 70%;
    border: 1px solid var(--el-border-color);
    border-radius: 0;
    margin-top: 20px;
  }
}

.border-group-shadow {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 10px;
  margin-top: 70px;

  .shadow-item {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    > div {
      width: 100px;
      height: 100px;
      background-color: var(--el-background-color);
    }

  }
}

$at-color-theme: 'primary' 'success' 'warning' 'info' 'danger';
$at-color-theme-dark: 'dark-2' 'light-3' 'light-5' 'light-7' 'light-8' 'light-9';


.colors-group {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  gap: 10px;
  padding: 10px 0;
  @each $color in $at-color-theme {
    .color-#{$color} {

      .card_top {
        background-color: var(--el-color-#{$color});
      }

      .card_bottom {
        @for $i from 1 through 6 {
          $element: nth($at-color-theme-dark, $i);
          .color:nth-child(#{$i}) {
            background-color: var(--el-color-#{$color}-#{$element});
          }
        }
      }
    }
  }

  .colors_card {
    width: 200px;
    height: 100px;
    border-radius: var(--el-border-radius-large);

    .card_top {
      height: 50px;
      display: flex;
      padding: 4px;
      box-sizing: border-box;
      flex-direction: column;
      justify-content: start;
      align-items: start;
      //background-color: var(--el-color-primary-);
    }

    .card_bottom {
      height: 30px;
      display: grid;
      grid-template-columns: repeat(6, 1fr);
    }
  }
}

.color-others {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 10px;

  .others-item {
    width: 100%;
    min-height: 80px;
    background-color: #ffffff;
    padding: 5px;
    border: rgba(0, 0, 0, 0.3) 0.3px solid;

    .others-item-title {
      font-size: 16px;
      width: 100%;
      min-height: 20px;
    }

    .others-item-value {
      display: grid;
      grid-template-columns: repeat(6, 1fr);
      gap: 0;

      span {
        width: 100%;
        height: 50px;
      }
    }
  }
}

.form-group {
  padding: 5px;
  border: #67c23a 1px dashed;
}

.demo-basic {
  text-align: center;

  .sub-title {
    margin-bottom: 10px;
    font-size: 14px;
    color: var(--el-text-color-secondary);
  }

  .demo-basic--circle, .demo-basic--square {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .block:not(:last-child) {
    border-right: 1px solid var(--el-border-color);
  }

  .block {
    flex: 1;
  }

  :deep(.el-col):not(:last-child) {
    border-right: 1px solid var(--el-border-color);
  }
}

.data-shows {
  display: grid;
  gap: 10px;
  margin: 5px 0px;

  .item {
    margin-top: 10px;
    margin-right: 30px;
  }

  .el-dropdown {
    margin-top: 1.1rem;
  }
}

.example-showcase :deep(.el-dropdown-link) {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}

:deep(.el-carousel__item) {
  h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
    text-align: center;
  }

  &:nth-child(2n) {
    background-color: #99a9bf;
  }

  &:nth-child(2n + 1) {
    background-color: #d3dce6;
  }
}

.demo-image {
  .block {
    padding: 30px 0;
    text-align: center;
    border-right: solid 1px var(--el-border-color);
    display: inline-block;
    width: 20%;
    box-sizing: border-box;
    vertical-align: top;
  }

  .block:last-child {
    border-right: none;
  }

  .demonstration {
    display: block;
    color: var(--el-text-color-secondary);
    font-size: 14px;
    margin-bottom: 20px;
  }
}

.infinite-list {
  height: 300px;
  padding: 0;
  margin: 0;
  list-style: none;

  .infinite-list-item {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 50px;
    background: var(--el-color-primary-light-9);
    margin: 10px;
    color: var(--el-color-primary);
  }

  .infinite-list-item + .list-item {
    margin-top: 10px;
  }
}

.demo-tags {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  column-gap: 70px;
}

.demo-tabs > :deep(.el-tabs__content) {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}

:deep(.el-alert) {
  margin: 20px 0 0;

  &:first-child {
    margin: 0;
  }
}

.w-full {
  width: 100%;
}

.alert-shows {
  display: grid;
  gap: 20px;
}

.tooltip-base-box {
  width: 600px;

  & .row {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  & .center {
    justify-content: center;
  }

  & .box-item {
    width: 110px;
    margin-top: 10px;
  }
}

.water-container {
  $uri: v-bind(url);
  width: 100%;
  min-height: 300px;
  background: #888888;
  background: url($uri) no-repeat;
  background-size: 100% 100%;
  position: relative;
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-between;

  .watermark {
    position: unset !important;
  }

  &-form-container {
    padding: 10px;
    background: white;
    width: 30%;
  }
}


.config-group {
  display: grid;
  gap: 10px;

  .config-item {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    justify-items: center;
    align-items: center;
  }


}

.config-colors {
  display: grid;
  grid-template-columns: repeat(6, 1fr);
}
</style>
