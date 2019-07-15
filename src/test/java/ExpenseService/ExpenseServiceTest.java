package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project = mock(Project.class);
        given(project.getProjectType()).willReturn(ProjectType.INTERNAL);
        given(project.getProjectName()).willReturn("jerryLi");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        verify(project,times(1));
        assertSame(expenseType,ExpenseType.INTERNAL_PROJECT_EXPENSE);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project project = mock(Project.class);
        given(project.getProjectType()).willReturn(ProjectType.EXTERNAL);
        given(project.getProjectName()).willReturn("Project A");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        verify(project,times(1));
        assertSame(expenseType,ExpenseType.EXPENSE_TYPE_A);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project project = mock(Project.class);
        given(project.getProjectType()).willReturn(ProjectType.EXTERNAL);
        given(project.getProjectName()).willReturn("Project B");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        verify(project,times(1));
        assertSame(expenseType,ExpenseType.EXPENSE_TYPE_B);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project project = mock(Project.class);
        given(project.getProjectType()).willReturn(ProjectType.EXTERNAL);
        given(project.getProjectName()).willReturn("jerryLi");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        verify(project,times(1));
        assertSame(expenseType,ExpenseType.OTHER_EXPENSE);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        // when
        // then
    }
}