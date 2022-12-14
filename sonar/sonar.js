const scanner = require('sonarqube-scanner');

scanner(
    {
        serverUrl: 'http://sonar-qb-prod.isoft-ste.com/',
        options: {
            'sonar.projectName': 'ejemplo-sidra-pa',
            'sonar.projectVersion': '1.0.0',
            'sonar.projectDescription': 'Backend test qa nodejs',
            'sonar.sources': '../solucredit-app-jasper/src/main/java',
            'sonar.login': 'd9618251fc7ab20cb7461e22831ddde5ca2050bc',
            'sonar.projectBaseDir': '../solucredit-app-jasper',
            'sonar.language': 'java',
            'sonar.java.binaries': '../solucredit-app-jasper/src/main/java'
        }
    },
    () => process.exit()
)



// git clone https://luis_perez_isoft:4S4cgB936mec6JvHeUFy@bitbucket.org/workspace_isoft/solucredit-app-jasper.git