# Spring Boot មេរៀនទី ១៧៖ Build, Container និង Deployment

## Artifact ដដែលគ្រប់ environment
Build executable JAR/WAR ហើយ configure environment ដោយ external config; កុំ build artifact មួយផ្សេងសម្រាប់ production ដោយកែ source។ ពិនិត្យ dependency vulnerability, license policy, SBOM/provenance តាមតម្រូវការក្រុម។

## Container
Spring Boot app អាចដាក់ក្នុង container image តាម Dockerfile ឬ buildpacks។ ប្រើ base image មានការថែទាំ, update ជាប្រចាំ, run as non-root, copy តែ artifact ចាំបាច់ និងកុំដាក់ secret ក្នុង image layer។ ប្រើ .dockerignore ដើម្បីមិនបញ្ជូន .git, credentials និង build outputs មិនចាំបាច់។

## Runtime configuration
ផ្តល់ DB URL, password, ports និង feature flags តាម environment/secret store។ កុំ bake secret ទៅ Dockerfile ARG/ENV ឬ image។ បញ្ជាក់ memory/cpu limits និង JVM container awareness តាម JDK version; កុំចម្លង -Xmx ដោយស្មាន។

## Health និង graceful shutdown
Configure readiness/liveness និង graceful shutdown ឱ្យ load balancer ឈប់ផ្ញើ request មុន process exit។ កំណត់ termination grace period ឱ្យសមនឹង in-flight work។ Worker/messaging consumers ត្រូវបញ្ចប់/ack message ឱ្យបានត្រឹម។

## Deploy និង rollback
ប្រើ rolling/canary ឬ blue-green deployment តាមប្រព័ន្ធ។ Schema migration ត្រូវ backward-compatible ពេល app version ច្រើនរត់ជាន់គ្នា។ រក្សា artifact/config version, database migration state និង rollback criteria។

## លំហាត់
1. រៀបចំ Dockerfile ដែល run app ជា non-root។
2. សរសេរ deployment checklist: config/secrets, health, logs, migration, rollback។
3. កំណត់តើ image ទទួល secret ពេល runtime ដូចម្តេច ដោយមិនចូល image layers។
