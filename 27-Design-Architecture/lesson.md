# មេរៀនទី ២៧៖ Design Patterns និង Software Architecture

## ១. Pattern ជាភាសារួម
Design pattern ជាឈ្មោះសម្រាប់របៀបដោះស្រាយបញ្ហារចនាដែលកើតញឹកញាប់។ វាមិនមែនជាច្បាប់ថាត្រូវអនុវត្តគ្រប់ project ទេ។ ប្រើ pattern ដើម្បីធ្វើឱ្យ intent ច្បាស់; កុំបន្ថែម abstraction ដោយសារចង់ឱ្យ code មើលទៅ “enterprise”។

## ២. Patterns ដែលជួបញឹកញាប់
- Strategy: ប្តូរ algorithm តាម interface។
- Factory: ប្រមូល logic បង្កើត object។
- Adapter: បម្លែង interface មួយឱ្យសមនឹងអ្នកប្រើ។
- Decorator: បន្ថែម behavior ដោយ wrap object។
- Observer: បញ្ជូន event ទៅ subscribers។

Java interfaces និង composition ជួយអនុវត្ត patterns ទាំងនេះដោយមិនចាំ inheritance ជាន់ច្រើន។

## ៣. Layering និង dependency direction
បំបែក domain logic, application orchestration, I/O adapters និង interface/API។ ច្បាប់សំខាន់គឺ domain logic មិនគួរចងជាមួយ database/web framework បើអាចជៀសបាន។ Dependency injection អនុញ្ញាតឱ្យផ្គត់ផ្គង់ implementation នៅ boundary និង test ជាមួយ fake។

## ៤. Cohesion និង coupling
Class មាន cohesion ល្អពេល method/field របស់វាបម្រើគោលបំណងតែមួយ។ Coupling ខ្ពស់ពេលការផ្លាស់ប្តូរផ្នែកមួយបង្ខំឱ្យកែផ្នែកច្រើន។ កុំបំបែក class រហូត interface ច្រើនជាង behavior ពិត; បែងចែកតាមការផ្លាស់ប្តូរ និង owner របស់ invariant។

## ៥. Refactoring និង design evidence
Refactoring រក្សា behavior ខណៈកែលម្អរចនា។ មាន tests មុន refactor។ កត់ trade-offs និង constraints។ Architecture diagram គួរបង្ហាញ boundary, data flow, failure modes និង dependencies មិនមែនតែ box ស្អាតៗ។

## លំហាត់
1. រចនា payment method ជា Strategy ដោយ CashPayment និង CardPayment។
2. បង្ហាញថា service ពឹង interface មិនពឹង implementation ផ្ទាល់។
3. ពិនិត្យ project មួយរបស់អ្នក ហើយសរសេរ class ដែលមាន coupling ខ្ពស់ និងជំហាន refactor មួយ។
