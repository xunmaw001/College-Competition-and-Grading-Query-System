const base = {
    get() {
        return {
            url : "http://localhost:8080/gaoxiaojingsai/",
            name: "gaoxiaojingsai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gaoxiaojingsai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校竞赛和考级查询系统"
        } 
    }
}
export default base
