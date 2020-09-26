drop table if exists `single_stock_realtime_info`;
create table `single_stock_realtime_info`
(
  `stock_id`                int(32)     not null auto_increment comment '自增id',
  `stock_no`                varchar(10) NOT NULL COMMENT '股票代码',
  `stock_name`              varchar(32) NOT NULL COMMENT '股票名字',
  `real_time`               timestamp   NOT NULL COMMENT '实时时间',
  `real_time_str`           timestamp   NOT NULL COMMENT '实时时间字符',
  `date`                    VARCHAR(10) not null comment '当天日期',
  `yesterday_closing_price` double(10, 10) comment '昨天收盘价',
  `closing_price`           double(10, 10) comment '今日收盘价',
  `opening_price`           double(10, 10) comment '开市价',
  `real_time_price`         double(10, 10) COMMENT '当前价格',
  `real_max_price`          double(10, 10) comment '当前最高价',
  `real_min_price`          double(10, 10) comment '当前最低价',
  `limit_max_price`         double(10, 10) comment '涨停价',
  `limit_min_price`         double(10, 10) comment '跌停价',
  `avg_price`               double(10, 10) comment '均价',
  `amount_of_increase`      double(10, 10) comment '涨幅',
  `change_price`            double(10, 10) COMMENT '涨跌金额',
  `turn_over_rate`          double(10, 10) COMMENT '换手率',
  `quantity_relative_ratio` double(10, 10) COMMENT '量比',
  `order_ratio`             double(10, 10) comment '委比',
  `order_diff`              double(10, 10) comment '委差',
  `volume`                  double(10, 10) comment '成交量',
  `volume_of_transaction`   double(10, 10) comment '成交额',
  `inside_dish`             DOUBLE(10, 10) COMMENT '内盘（主动卖）',
  `out_side_dish`           double(10, 10) comment '外盘（主动买）',
  `avg_60_price`            double(10, 10) comment '60日均线',
  `avg_30_price`            double(10, 10) comment '30日均线',
  `avg_10_price`            double(10, 10) COMMENT '10日均线',
  `avg_5_price`             double(10, 10) COMMENT '5日均线',
  `comments`                varchar(1024) comment '点评',
  PRIMARY key (`stock_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

drop table if exists `single_stock_cfg`;
CREATE TABLE `single_stock_cfg`
(
  `stock_no`            varchar(10) NOT NULL COMMENT '股票代码',
  `stock_name`          varchar(32) NOT NULL COMMENT '股票名字',
  `create_time`         timestamp   NOT NULL COMMENT '创建时间',
  `update_time`         timestamp   NOT NULL COMMENT '更新时间',
  `statistic_count_cfg` int(3)      NOT NULL COMMENT '每日更新次数',
  `stock_type`          int(1)      not null default 2 comment '股票类型',
  `stock_classified`    varchar(128) comment '股票种类',
  `stock_url`           varchar(128) not null comment '股票url',
  PRIMARY KEY (`stock_no`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

drop table if exists `stock_type`;
create table `stock_type`
(
  `stock_type`      int(16)     not null comment '股票类型',
  `stock_type_name` varchar(32) not null comment '股票类型名称',
  `create_time`     timestamp   not null comment '创建时间',
  primary key (`stock_type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;