## 基本需求：

##### 语音设置训练参数，并执行对应实验

## 模块分类：

-   语音输入模型参数
-   参数配置文件正确性check
-   自动化运行实验

### 具体模块(语音输入模型参数)

-   以不可变字典形式，新增需要手动维护输入，语音只完成匹配工作
-   设置的结果会有成功与否的反馈提示，对于每个模型参数有专门的check，默认值，也可在中途跳过该设置
-   对于某个参数，提供一定的推荐选项并显示
-   全局对所有参数的正确性check

### 具体模块(根据配置文件自动化运行试验)

-   在shell中显示配置文件的所有内容
-   在远程服务器上创建试验，scp并保存配置文件信息
-   实验过程中监控log
-   实验结束后反馈试验标准统计量