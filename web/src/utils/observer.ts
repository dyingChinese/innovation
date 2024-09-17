const GlobalResizeObserverSymbol = Symbol.for('GlobalResizeObserver');
export const GlobalResizeObserver = (function () {
    const ATTR_NAME = Symbol('globalResizeobserver');

    // const attrValueToCallback: AttrValueToCallbackType = {};
    const attrValueToCallback = new Map<Element, (entry: ResizeObserverEntry) => void>();

    const BrowseObserver = new ResizeObserver((entries) => {
        for (const entry of entries) {
            const resizedElement = entry.target;
            const attrValue = resizedElement.getAttribute(ATTR_NAME.description!);
            if (attrValue) {
                // const callback = attrValueToCallback[attrValue];
                const callback = attrValueToCallback.get(resizedElement);
                if (typeof callback === 'function') {
                    callback(entry);
                }
            }
        }
    });

    return Object.freeze({
        observe(element: Element, callback: (entry: ResizeObserverEntry) => {}) {
            if (!(element instanceof Element)) {
                console.error('GlobalResizeObserver, cannot observe non-Element.');
                return;
            }

            let attrValue = element.getAttribute(ATTR_NAME.description!);

            if (!attrValue) {
                attrValue = String(Math.random());
                element.setAttribute(ATTR_NAME.description!, attrValue);
            }
            // attrValueToCallback[attrValue] = callback;
            attrValueToCallback.set(element, callback);
            BrowseObserver.observe(element);
        },

        /**
         * @param { Element } element
         */
        unobserve(element: Element) {
            if (!(element instanceof Element)) {
                console.error('GlobalResizeObserver cannot unobserve non-Element.');
                return;
            }
            const attrValue = element.getAttribute(ATTR_NAME.description!);
            if (!attrValue) {
                console.error('GlobalResizeObserver cannot unobserve element w/o ATTR_NAME.');
                return;
            }
            // delete attrValueToCallback[attrValue];
            attrValueToCallback.delete(element);
            BrowseObserver.unobserve(element);
        }
    });
})();

export default {
    install(app: any) {
        app.provide(GlobalResizeObserverSymbol, GlobalResizeObserver);
    }
}
