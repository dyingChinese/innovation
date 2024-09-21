import {CSSProperties, RenderFunction, VNodeChild} from "vue";
import type {Filters} from "element-plus/es/components/table/src/table-column/defaults";
import {ElTooltipTriggerProps} from "element-plus";

type BaseType = number | string | symbol | boolean

interface TableBorder {
    wrapper: boolean //  是否展示外边框
    cell: boolean//是否展示单元格边框（表头+主体）
    headerCell: boolean  //是否展示表头单元格边框
    bodyCell: boolean  //是否展示主体单元格边框
}

interface TableChangeExtra {
    type: 'pagination' | 'sorter' | 'filter' | 'drag' //触发类型
    page: number  //页码
    pageSize: number  //每页数据数
    sorter: any   //排序信息
    filters: Filters  //筛选信息
    dragTarget: TableData  //拖拽信息
}

interface TableSortable {
    sortDirections: ('ascend' | 'descend')[];
    sorter: ((a: TableData, b: TableData, extra: {
        dataIndex: string;
        direction: 'ascend' | 'descend'
    }) => number) | boolean;
    sortOrder: 'ascend' | 'descend' | '';
    defaultSortOrde: 'ascend' | 'descend' | ''
}

interface TableDraggable {
    type: 'row' | 'handle'  //拖拽类型
    title: string  //列标题
    width: number // 列宽度
    fixed: boolean  //是否固定
}

interface TableFilterable {
    filters: TableFilterData[]; //筛选数据
    filter: (filteredValue: string[], record: TableData) => boolean //筛选函数
    multiple: boolean //是否支持多选
    filteredValue: string[] //筛选项
    defaultFilteredValue: string[]//默认筛选项
    renderContent: (data: {
        filterValue: string[];
        setFilterValue: (filterValue: string[]) => void;
        handleFilterConfirm: (event: Event) => void;
        handleFilterReset: (event: Event) => void;
    }) => VNodeChild//筛选框的内容
    icon: RenderFunction //  筛选按钮的图标
    triggerProps: ElTooltipTriggerProps //  筛选框的弹出框配置
    alignLeft: boolean //筛选图标是否左对齐
}

interface TableFilterData {
    text: string | RenderFunction  //筛选数据选项的内容
    value: string  //筛选数据选项的值
}

interface TableData {
    key: string  //数据行的key
    expand: string | RenderFunction  //扩展行内容
    children: TableData[]  //子数据
    disabled: boolean  //是否禁用行选择器
    isLeaf: boolean  //是否是叶子节点
}


interface TableRowSelection {
    type: 'checkbox' | 'radio'  //行选择器的类型
    selectedRowKeys: BaseType[]  //已选择的行（受控模式）
    defaultSelectedRowKeys: BaseType[]  //默认已选择的行（非受控模式）
    showCheckedAll: boolean  //是否显示全选选择器
    title: string  //列标题
    width: number //列宽度
    fixed: boolean  //是否固定
    checkStrictly: boolean  //是否开启严格选择模式
    onlyCurrent: boolean  //是否仅展示当前页的 keys（切换分页时清空 keys）
}

interface TableExpandable {
    expandedRowKeys: BaseType[]  //显示的展开行（受控模式）
    defaultExpandedRowKeys: BaseType[]  //默认显示的展开行（非受控模式）
    defaultExpandAllRows: boolean  //是否默认展开所有的行
    expandedRowRender: (record: TableData) => VNodeChild  //自定义展开行内容
    icon: (expanded: boolean, record: TableData) => VNodeChild  //展开图标
    title: string  //列标题
    width: number  //列宽度
    fixed: boolean  //是否固定
}

interface CommonTableColumnPropsType {
    dataIndex: string;
    title: string | RenderFunction;
    width: number;
    minWidth: number;
    align: 'left' | 'center' | 'right';
    fixed: 'left' | 'right';
    ellipsis: boolean;
    tooltip: boolean | Record<string, any>;
    sortable: TableSortable;
    filterable: TableFilterable;
    children: CommonTableColumnPropsType[]
    cellClass: string;
    headerCellClass: string;// 自定义表头单元格类名
    bodyCellClass: string | ((record: TableData) => string); // 自定义内容单元格类名
    summaryCellClass: string | ((record: TableData) => string);  // 自定义总结栏单元格类名
    cellStyle: CSSProperties;// 自定义单元格样式
    headerCellStyle: CSSProperties;  //  自定义表头单元格样式
    bodyCellStyle: CSSProperties | ((record: TableData) => CSSProperties)//自定义内容单元格样式
    summaryCellStyle: CSSProperties | ((record: TableData) => CSSProperties) // 自定义总结栏单元格样式
    render: (data: { record: TableData; column: CommonTableColumnPropsType; rowIndex: number; }) => VNodeChild //自定义列单元格的渲染
    slotName: string // 设置当前列的渲染插槽的名字。插槽参数同 #cell
    titleSlotName: string //设置当前列的标题的渲染插槽的名字
}

interface CommonTableProps {
    tableMeta: {
        title?: string;
        onlyRead?: boolean;
        rowKey: string
    },
    tableData: Array<{}>;
    column: Array<CommonTableColumnPropsType>;
    pagination?: {
        pageSize: number,
        currentPage: number,
        total: number
    }
}

export  type {
    CommonTableProps,
    TableBorder, TableChangeExtra, TableSortable, TableDraggable, TableFilterable,
    TableRowSelection, TableExpandable
}


// import type { CSSProperties, ComponentInternalInstance, PropType, Ref, VNode } from 'vue';
// import type { ComponentSize } from 'element-plus/es/constants';
// import type { Nullable } from 'element-plus/es/utils';
// import type { Store } from '../store';
// import type { TableColumnCtx } from '../table-column/defaults';
// import type TableLayout from '../table-layout';
// import type { TableOverflowTooltipOptions } from '../util';
// export declare type DefaultRow = any;
// interface TableRefs {
//     tableWrapper: HTMLElement;
//     headerWrapper: HTMLElement;
//     footerWrapper: HTMLElement;
//     fixedBodyWrapper: HTMLElement;
//     rightFixedBodyWrapper: HTMLElement;
//     bodyWrapper: HTMLElement;
//     appendWrapper: HTMLElement;
//     [key: string]: any;
// }
// interface TableState {
//     isGroup: Ref<boolean>;
//     resizeState: Ref<{
//         width: any;
//         height: any;
//     }>;
//     doLayout: () => void;
//     debouncedUpdateLayout: () => void;
// }
// interface TreeProps {
//     hasChildren?: string;
//     children?: string;
//     checkStrictly?: boolean;
// }
// declare type HoverState<T> = Nullable<{
//     cell: HTMLElement;
//     column: TableColumnCtx<T>;
//     row: T;
// }>;
// declare type RIS<T> = {
//     row: T;
//     $index: number;
//     store: Store<T>;
//     expanded: boolean;
// };
// declare type RenderExpanded<T> = ({ row, $index, store, expanded: boolean, }: RIS<T>) => VNode;
// declare type SummaryMethod<T> = (data: {
//     columns: TableColumnCtx<T>[];
//     data: T[];
// }) => (string | VNode)[];
// interface Table<T> extends ComponentInternalInstance {
//     $ready: boolean;
//     hoverState?: HoverState<T>;
//     renderExpanded: RenderExpanded<T>;
//     store: Store<T>;
//     layout: TableLayout<T>;
//     refs: TableRefs;
//     tableId: string;
//     state: TableState;
// }
// declare type ColumnCls<T> = string | ((data: {
//     row: T;
//     rowIndex: number;
// }) => string);
// declare type ColumnStyle<T> = CSSProperties | ((data: {
//     row: T;
//     rowIndex: number;
// }) => CSSProperties);
// declare type CellCls<T> = string | ((data: {
//     row: T;
//     rowIndex: number;
//     column: TableColumnCtx<T>;
//     columnIndex: number;
// }) => string);
// declare type CellStyle<T> = CSSProperties | ((data: {
//     row: T;
//     rowIndex: number;
//     column: TableColumnCtx<T>;
//     columnIndex: number;
// }) => CSSProperties);
// declare type Layout = 'fixed' | 'auto';
// interface TableProps<T> {
//     data: T[];
//     size?: ComponentSize;
//     width?: string | number;
//     height?: string | number;
//     maxHeight?: string | number;
//     fit?: boolean;
//     stripe?: boolean;
//     border?: boolean;
//     rowKey?: string | ((row: T) => string);
//     context?: Table<T>;
//     showHeader?: boolean;
//     showSummary?: boolean;
//     sumText?: string;
//     summaryMethod?: SummaryMethod<T>;
//     rowClassName?: ColumnCls<T>;
//     rowStyle?: ColumnStyle<T>;
//     cellClassName?: CellCls<T>;
//     cellStyle?: CellStyle<T>;
//     headerRowClassName?: ColumnCls<T>;
//     headerRowStyle?: ColumnStyle<T>;
//     headerCellClassName?: CellCls<T>;
//     headerCellStyle?: CellStyle<T>;
//     highlightCurrentRow?: boolean;
//     currentRowKey?: string | number;
//     emptyText?: string;
//     expandRowKeys?: string[];
//     defaultExpandAll?: boolean;
//     defaultSort?: Sort;
//     tooltipEffect?: string;
//     tooltipOptions?: TableOverflowTooltipOptions;
//     spanMethod?: (data: {
//         row: T;
//         rowIndex: number;
//         column: TableColumnCtx<T>;
//         columnIndex: number;
//     }) => number[] | {
//         rowspan: number;
//         colspan: number;
//     } | undefined;
//     selectOnIndeterminate?: boolean;
//     indent?: number;
//     treeProps?: TreeProps;
//     lazy?: boolean;
//     load?: (row: T, treeNode: TreeNode, resolve: (data: T[]) => void) => void;
//     className?: string;
//     style?: CSSProperties;
//     tableLayout?: Layout;
//     scrollbarAlwaysOn?: boolean;
//     flexible?: boolean;
//     showOverflowTooltip?: boolean | TableOverflowTooltipOptions;
//     scrollbarTabindex?: number | string;
// }
// interface Sort {
//     prop: string;
//     order: 'ascending' | 'descending';
//     init?: any;
//     silent?: any;
// }
// interface Filter<T> {
//     column: TableColumnCtx<T>;
//     values: string[];
//     silent: any;
// }
// interface TreeNode {
//     expanded?: boolean;
//     loading?: boolean;
//     noLazyChildren?: boolean;
//     indent?: number;
//     level?: number;
//     display?: boolean;
// }
// interface RenderRowData<T> {
//     store: Store<T>;
//     _self: Table<T>;
//     column: TableColumnCtx<T>;
//     row: T;
//     $index: number;
//     treeNode?: TreeNode;
//     expanded: boolean;
// }
// declare const _default: {
//     /**
//      * @description table data
//      */
//     data: {
//         type: PropType<any[]>;
//         default: () => never[];
//     };
//     /**
//      * @description size of Table
//      */
//     size: {
//         readonly type: PropType<import("element-plus/es/utils").EpPropMergeType<StringConstructor, "" | "small" | "default" | "large", never>>;
//         readonly required: false;
//         readonly validator: ((val: unknown) => boolean) | undefined;
//         __epPropKey: true;
//     };
//     width: (NumberConstructor | StringConstructor)[];
//     /**
//      * @description table's height. By default it has an `auto` height. If its value is a number, the height is measured in pixels; if its value is a string, the value will be assigned to element's style.height, the height is affected by external styles
//      */
//     height: (NumberConstructor | StringConstructor)[];
//     /**
//      * @description table's max-height. The legal value is a number or the height in px
//      */
//     maxHeight: (NumberConstructor | StringConstructor)[];
//     /**
//      * @description whether width of column automatically fits its container
//      */
//     fit: {
//         type: BooleanConstructor;
//         default: boolean;
//     };
//     /**
//      * @description whether Table is striped
//      */
//     stripe: BooleanConstructor;
//     /**
//      * @description whether Table has vertical border
//      */
//     border: BooleanConstructor;
//     /**
//      * @description key of row data, used for optimizing rendering. Required if `reserve-selection` is on or display tree data. When its type is String, multi-level access is supported, e.g. `user.info.id`, but `user.info[0].id` is not supported, in which case `Function` should be used
//      */
//     rowKey: PropType<string | ((row: any) => string) | undefined>;
//     /**
//      * @description whether Table header is visible
//      */
//     showHeader: {
//         type: BooleanConstructor;
//         default: boolean;
//     };
//     /**
//      * @description whether to display a summary row
//      */
//     showSummary: BooleanConstructor;
//     /**
//      * @description displayed text for the first column of summary row
//      */
//     sumText: StringConstructor;
//     /**
//      * @description custom summary method
//      */
//     summaryMethod: PropType<SummaryMethod<any> | undefined>;
//     /**
//      * @description function that returns custom class names for a row, or a string assigning class names for every row
//      */
//     rowClassName: PropType<ColumnCls<any> | undefined>;
//     /**
//      * @description function that returns custom style for a row, or an object assigning custom style for every row
//      */
//     rowStyle: PropType<ColumnStyle<any> | undefined>;
//     /**
//      * @description function that returns custom class names for a cell, or a string assigning class names for every cell
//      */
//     cellClassName: PropType<CellCls<any> | undefined>;
//     /**
//      * @description function that returns custom style for a cell, or an object assigning custom style for every cell
//      */
//     cellStyle: PropType<CellStyle<any> | undefined>;
//     /**
//      * @description function that returns custom class names for a row in table header, or a string assigning class names for every row in table header
//      */
//     headerRowClassName: PropType<ColumnCls<any> | undefined>;
//     /**
//      * @description function that returns custom style for a row in table header, or an object assigning custom style for every row in table header
//      */
//     headerRowStyle: PropType<ColumnStyle<any> | undefined>;
//     /**
//      * @description function that returns custom class names for a cell in table header, or a string assigning class names for every cell in table header
//      */
//     headerCellClassName: PropType<CellCls<any> | undefined>;
//     /**
//      * @description function that returns custom style for a cell in table header, or an object assigning custom style for every cell in table header
//      */
//     headerCellStyle: PropType<CellStyle<any> | undefined>;
//     /**
//      * @description whether current row is highlighted
//      */
//     highlightCurrentRow: BooleanConstructor;
//     /**
//      * @description key of current row, a set only prop
//      */
//     currentRowKey: (NumberConstructor | StringConstructor)[];
//     /**
//      * @description displayed text when data is empty. You can customize this area with `#empty`
//      */
//     emptyText: StringConstructor;
//     /**
//      * @description set expanded rows by this prop, prop's value is the keys of expand rows, you should set row-key before using this prop
//      */
//     expandRowKeys: PropType<string[] | undefined>;
//     /**
//      * @description whether expand all rows by default, works when the table has a column type="expand" or contains tree structure data
//      */
//     defaultExpandAll: BooleanConstructor;
//     /**
//      * @description set the default sort column and order. property `prop` is used to set default sort column, property `order` is used to set default sort order
//      */
//     defaultSort: PropType<Sort | undefined>;
//     /**
//      * @description the `effect` of the overflow tooltip
//      */
//     tooltipEffect: StringConstructor;
//     /**
//      * @description the options for the overflow tooltip, [see the following tooltip component](tooltip.html#attributes)
//      */
//     tooltipOptions: PropType<Partial<Pick<import("../../..").ElTooltipProps, "offset" | "transition" | "placement" | "effect" | "showAfter" | "hideAfter" | "popperOptions" | "enterable" | "popperClass" | "appendTo" | "showArrow">> | undefined>;
//     /**
//      * @description method that returns rowspan and colspan
//      */
//     spanMethod: PropType<((data: {
//         row: any;
//         rowIndex: number;
//         column: TableColumnCtx<any>;
//         columnIndex: number;
//     }) => number[] | {
//         rowspan: number;
//         colspan: number;
//     } | undefined) | undefined>;
//     /**
//      * @description controls the behavior of master checkbox in multi-select tables when only some rows are selected (but not all). If true, all rows will be selected, else deselected
//      */
//     selectOnIndeterminate: {
//         type: BooleanConstructor;
//         default: boolean;
//     };
//     /**
//      * @description horizontal indentation of tree data
//      */
//     indent: {
//         type: NumberConstructor;
//         default: number;
//     };
//     /**
//      * @description configuration for rendering nested data
//      */
//     treeProps: {
//         type: PropType<TreeProps | undefined>;
//         default: () => {
//             hasChildren: string;
//             children: string;
//             checkStrictly: boolean;
//         };
//     };
//     /**
//      * @description whether to lazy loading data
//      */
//     lazy: BooleanConstructor;
//     /**
//      * @description method for loading child row data, only works when `lazy` is true
//      */
//     load: PropType<((row: any, treeNode: TreeNode, resolve: (data: any[]) => void) => void) | undefined>;
//     style: {
//         type: PropType<CSSProperties>;
//         default: () => {};
//     };
//     className: {
//         type: StringConstructor;
//         default: string;
//     };
//     /**
//      * @description sets the algorithm used to lay out table cells, rows, and columns
//      */
//     tableLayout: {
//         type: PropType<Layout>;
//         default: string;
//     };
//     /**
//      * @description always show scrollbar
//      */
//     scrollbarAlwaysOn: BooleanConstructor;
//     /**
//      * @description ensure main axis minimum-size doesn't follow the content
//      */
//     flexible: BooleanConstructor;
//     /**
//      * @description whether to hide extra content and show them in a tooltip when hovering on the cell.It will affect all the table columns
//      */
//     showOverflowTooltip: PropType<boolean | Partial<Pick<import("../../..").ElTooltipProps, "offset" | "transition" | "placement" | "effect" | "showAfter" | "hideAfter" | "popperOptions" | "enterable" | "popperClass" | "appendTo" | "showArrow">> | undefined>;
//     scrollbarTabindex: {
//         type: (NumberConstructor | StringConstructor)[];
//         default: undefined;
//     };
// };
// export default _default;
// export type { SummaryMethod, Table, TableProps, TableRefs, ColumnCls, ColumnStyle, CellCls, CellStyle, TreeNode, RenderRowData, Sort, Filter, TableColumnCtx, TreeProps, };
