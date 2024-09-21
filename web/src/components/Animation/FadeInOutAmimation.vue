<template>
  <div class="text-container" @mousewheel="handleMouseWheel" @mouseup.passive="handleTouchStart"
       @mousedown.passive="handleTouchEnd">
    <transition
        name="fade"
        @before-enter="beforeEnter"
        @enter="enter"
        @leave="leave"
    >
      <div v-if="customAttar.showLine" class="text-line" v-text="customAttar.lines[customAttar.currentLineIndex]"></div>
    </transition>

  </div>

</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';

interface CustomAttr {
  textContent: string;
  lines: string[];
  currentLineIndex: number;
  showLine: boolean;
  timer?: NodeJS.Timeout;
  touchStartY: number;
  touchStartX: number;
  debounceTimer?: NodeJS.Timeout;
}

const customAttar = ref<CustomAttr>({
  textContent: "程序员们\n你们好\n你们想的\n 我们都知道",
  lines: [],
  currentLineIndex: 0,
  showLine: false,
  touchStartY: 0,
  touchStartX: 0
});

onMounted(() => {
  customAttar.value.lines = customAttar.value.textContent.split('\n');
  nextLine();
});

const handleTouchStart = (event: TouchEvent) => {
  customAttar.value.touchStartY = event.touches[0].clientY;
};
const handleMouseWheel = (event: MouseEvent) => {
  // const  direction = e.deltaY > 50 ? 'down':'up';  //deltaY为正则滚轮向下，为负滚轮向上
  clearTimeout(customAttar.value.debounceTimer);
  customAttar.value.debounceTimer = setTimeout(() => {
    const direction = event.deltaY;
    console.log('direction ' + (direction > 50 ? 'up' : 'down'))
    if (direction > 50) {
      prevLine();
    } else if (direction < -50) {
      nextLine();
    }
  }, 300);
}
const handleTouchEnd = (event: TouchEvent) => {
  const touchEndY = event.changedTouches[0].clientY;
  const deltaY = touchEndY - customAttar.value.touchStartY;
  clearTimeout(customAttar.value.debounceTimer);
  customAttar.value.debounceTimer = setTimeout(() => {
    if (deltaY > 50) {
      prevLine();
    } else if (deltaY < -50) {
      nextLine();
    }
  }, 300);
};

const nextLine = () => {
  if (customAttar.value.currentLineIndex < customAttar.value.lines.length) {
    customAttar.value.showLine = true;
    startTimer();
  } else {
    stopAnimation();
  }
};

const prevLine = () => {
  if (customAttar.value.currentLineIndex > 0) {
    customAttar.value.currentLineIndex--;
    customAttar.value.showLine = false;
    setTimeout(() => {
      customAttar.value.showLine = true;
      startTimer();
    }, 1800);
  }
};

const startTimer = () => {
  customAttar.value.timer = setTimeout(() => {
    customAttar.value.showLine = false;
    customAttar.value.currentLineIndex++;
    setTimeout(nextLine, 1800);
  }, 2000);
};

const stopAnimation = () => {
  if (customAttar.value.timer) {
    clearTimeout(customAttar.value.timer);
  }
};

const beforeEnter = (el: HTMLElement) => {
  el.style.opacity = '0';
};

const enter = (el: HTMLElement, done: () => void) => {
  el.style.transition = 'opacity 1.8s';
  el.style.opacity = '1';
  setTimeout(() => {
    done();
  }, 1800);
};

const leave = (el: HTMLElement, done: () => void) => {
  el.style.opacity = '0';
  setTimeout(() => {
    done();
  }, 1800);
};
</script>
<style>
.text-line {
  font-size: 40px;
  font-weight: bolder;
  text-align: center;
  margin-top: 120px;
}

.fade-enter-active {
  animation: fade-enter 1.8s 1 cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

.fade-leave-active {
  animation: fade-leave 1.8s 1 cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

.fade-enter, .fade-leave-to {
  opacity: 0;
}

@keyframes fade-enter {
  from {
    /* 加上文字间距 */
    letter-spacing: 1em;
    /* Z轴变换 */
    transform: translateZ(300px);
    /* filter: blur(); 像素模糊效果 */
    filter: blur(12px);
    /* 透明度也要改变 */
    opacity: 0;
  }

  to {
    transform: translateZ(12px);
    filter: blur(0);
    opacity: 1;
  }
}

@keyframes fade-leave {
  from {
    transform: translateZ(0);
    filter: blur(0.01);
  }

  to {
    letter-spacing: 1em;
    transform: translateZ(300px);
    filter: blur(12px) opacity(0%);
  }
}
</style>
