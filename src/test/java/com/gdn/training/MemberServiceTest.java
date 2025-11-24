package com.gdn.training;

import com.gdn.training.dummy.entity.Member;
import com.gdn.training.dummy.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Member Service Test")
@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

  @Mock
  private MemberRepository memberRepository;

  @InjectMocks
  private MemberService memberService;

  @Test
  @DisplayName("suspendMember successfully suspends an active member")
  public void suspendMemberSuccessTest() {
    String memberId = "M001";
    Member activeMember = Member.builder()
        .id(memberId)
        .name("John Doe")
        .email("john@example.com")
        .suspended(false)
        .build();

    when(memberRepository.getMember(memberId)).thenReturn(activeMember);

    memberService.suspendMember(memberId);

    verify(memberRepository, times(1)).getMember(memberId);
    verify(memberRepository, times(1)).save(activeMember);
    assertTrue(activeMember.isSuspended());
  }

  @Test
  @DisplayName("suspendMember throws exception when member not found")
  public void suspendMemberNotFoundTest() {
    String memberId = "M999";

    when(memberRepository.getMember(memberId)).thenReturn(null);

    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
      memberService.suspendMember(memberId);
    });

    assertEquals("Member not found", exception.getMessage());
    verify(memberRepository, times(1)).getMember(memberId);
    verify(memberRepository, never()).save(any());
  }

  @Test
  @DisplayName("suspendMember throws exception when member already suspended")
  public void suspendMemberAlreadySuspendedTest() {
    String memberId = "M002";
    Member suspendedMember = Member.builder()
        .id(memberId)
        .name("Jane Doe")
        .email("jane@example.com")
        .suspended(true)
        .build();

    when(memberRepository.getMember(memberId)).thenReturn(suspendedMember);

    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
      memberService.suspendMember(memberId);
    });

    assertEquals("Member already suspended", exception.getMessage());
    verify(memberRepository, times(1)).getMember(memberId);
    verify(memberRepository, never()).save(any());
  }

  @Test
  @DisplayName("suspendMember verifies repository interactions")
  public void suspendMemberVerifiesRepositoryInteractionsTest() {
    String memberId = "M003";
    Member member = Member.builder()
        .id(memberId)
        .name("Bob Smith")
        .email("bob@example.com")
        .suspended(false)
        .build();

    when(memberRepository.getMember(memberId)).thenReturn(member);

    memberService.suspendMember(memberId);

    verify(memberRepository).getMember(memberId);
    verify(memberRepository).save(argThat(m ->
        m.getId().equals(memberId) && m.isSuspended()
    ));
  }
}
